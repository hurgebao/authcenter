package com.none.authcenter.controller;

import com.none.authcenter.common.CodeConstants;
import com.none.authcenter.dao.LicenceKeyInfoMapper;
import com.none.authcenter.utils.STD3DesUtil;
import com.none.authcenter.utils.SeedUtils;
import com.none.authcenter.utils.ValidateUtils;
import com.none.authcenter.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by admin on 2019/9/26.
 * 1、license文件授权
 * 2、绑定ip和mac
 * 3、限制使用日期，并能防止客户自己修改时间
 * 4、限制范围：禁止登录系统，数据加密防止登录数据库查询，完全删除代码和数据
 * 5、替换license文件即可延期
 *
 */
@RestController
@Api(tags = "认证")
public class AuthController {
    private static Logger logger= LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private LicenceKeyInfoMapper licenceKeyInfoMapper;
    String key="f510b8737344cddbca1c8564";
    @PostMapping("auth")
    @ApiOperation(value = "auth")
    public BaseResponse auth(@RequestBody AuthRequest request){
        BaseResponse response=new BaseResponse();
        try {
            ValidateUtils.validate(request);
        } catch (Exception e) {
            response.setMsg(e.getMessage());
            response.setCode(CodeConstants.BAD_REQUEST_EXCEPTION);
            logger.info("认证请求检验未通过：{}", e.getMessage());
            return response;
        }
        logger.info("开始认证:request={}",request);
        try {
            String data= request.getData();
            request.setData(null);
            String msg=STD3DesUtil.des3EncodeECBBase64String(key, request.toString());
            logger.info("request签名:{}",msg);
            if(data.equals(msg)){
                String mingwen=STD3DesUtil.des3DecodeECBBase64String(key,request.getLicenceKey());
                logger.info("明文:{}",mingwen);
                LicenceKeySeed seed = SeedUtils.getLicenceKeySeed(mingwen);
                LicenceKeyInfo licenceK = licenceKeyInfoMapper.selectBySeed(seed);
                if(licenceK!=null && SeedUtils.assertEquels(seed, licenceK)){
                    response.setCode(CodeConstants.SUCCESS);
                    response.setMsg(msg);
                    logger.info("认证结束，结果{}",response);
                    return response;
                }
            }
            response.setCode(CodeConstants.AUTH_FAIL);
            response.setMsg("认证未通过");
        }catch (Exception e){
            logger.error("认证异常{}",e);
            response.setMsg(e.getMessage());
            response.setCode(CodeConstants.UNKNOW_EXCEPTION);
        }
        logger.info("认证结束，结果{}",response);
        return response;
    }
    @PostMapping("key")
    @ApiOperation(value = "getLicenceKey")
    public EntityResponse<String> getLicenceKey(@RequestBody LicenceKeySeed seed){

        EntityResponse response=new EntityResponse();
        try {
            ValidateUtils.validate(seed);
        } catch (Exception e) {
            logger.info("获取licenceKey参数错误{}", e.getMessage());
            response.setCode(CodeConstants.BAD_REQUEST_EXCEPTION);
            response.setMsg(e.getMessage());
            return response;
        }
        logger.info("获取LicenceKey，seed={}",seed);
        try {
            LicenceKeyInfo licenceK = licenceKeyInfoMapper.selectBySeed(seed);
            if(licenceK!=null){
                response.setCode(CodeConstants.SUCCESS);
                response.setMsg("success");
                response.setT(licenceK.getLicenceKey());
                return response;
            }
            String data=SeedUtils.generateHeaderLength(seed)+ SeedUtils.generateHeader(seed);
            logger.info("LicenceKey，明文={}", data);
            String licenceKey= STD3DesUtil.des3EncodeECBBase64String(key, data);
            logger.info("LicenceKey,密文={}", licenceKey);
            LicenceKeyInfo licenceKeyInfo=new LicenceKeyInfo();
            licenceKeyInfo.setExpireDate(seed.getExpireDate());
            licenceKeyInfo.setMac(seed.getMac());
            licenceKeyInfo.setLicenceKey(licenceKey);
            licenceKeyInfo.setLicenceKeySeed(data);
            licenceKeyInfo.setOrgCode(seed.getOrgCode());
            licenceKeyInfo.setSalt(seed.getSalt());
            licenceKeyInfo.setIp(seed.getIp());
            licenceKeyInfoMapper.insertSelective(licenceKeyInfo);
            response.setCode(CodeConstants.SUCCESS);
            response.setMsg("success");
            response.setT(licenceKey);
            return response;
        } catch (Exception e) {
            logger.error("获取licenceKey异常{}", e);
            response.setCode(CodeConstants.UNKNOW_EXCEPTION);
            response.setMsg(e.getMessage());
            return response;
        }
    }

}
