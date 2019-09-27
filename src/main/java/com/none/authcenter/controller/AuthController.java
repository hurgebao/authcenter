package com.none.authcenter.controller;

import com.alibaba.fastjson.JSON;
import com.none.authcenter.utils.STD3DesUtil;
import com.none.authcenter.vo.AuthRequest;
import com.none.authcenter.vo.AuthResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
public class AuthController {
    String key="f510b8737344cddbca1c8564";
    @PostMapping("auth")
    public AuthResponse auth(@RequestBody AuthRequest request){
        System.out.println(request);
        AuthResponse response=new AuthResponse();
        response.setCode("0000");
        try{
            response.setMsg(STD3DesUtil.des3EncodeECBBase64String( key,  request.toString()));
        }catch (Exception e){
            response.setMsg("error");
        }
        return response;
    }
    @GetMapping("key")
    public String getKey(){
        return key;
    }
}
