package com.none.authcenter.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.none.authcenter.vo.AuthRequest;
import com.none.authcenter.vo.LicenceKeySeed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by admin on 2019/10/14.
 */
public class AuthUtil {
    private static Logger logger = LoggerFactory.getLogger("auth");
    public static  String LICENCE_KEY=null;
    static{
//        init();
    }

    private static void init() {
//        File file = new File("/home/www/trade.lic");
        File file = new File("d:/trade.lic");
        if (!file.exists() ||  !file.canRead()){
            logger.error("未读取到授权文件");
            throw new RuntimeException("未读取到授权文件");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line="";
            while ((line= bufferedReader.readLine())!=null){
                LICENCE_KEY=line;
            }
        } catch (Exception e) {
            throw new RuntimeException("请更新系统许可证");
        }
    }

    public static String auth() throws Exception {
        if(LICENCE_KEY==null || LICENCE_KEY.length()<=0){
            throw new RuntimeException("未找到许可证信息");
        }
        String url = "http://auth-server:8081/auth";
        AuthRequest request = new AuthRequest();
        request.setIp(MonitorUtil.getIp());
        request.setMac(MonitorUtil.getLocalMac());
        request.setLicenceKey(LICENCE_KEY);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        request.setAuthTime(sdf.format(new Date()));
        LicenceKeySeed seed=getKeySeed(LICENCE_KEY);
        if(seed==null || seed.getOrgCode()==null){
            throw new RuntimeException("许可证信息已被篡改");
        }

        request.setOrgCode(seed.getOrgCode());
        request.setExpireDate(seed.getExpireDate());
        request.setRemainDay(85);
        request.setData("no");
        String res = HttpClientUtil.post(url, request);
        return res;
    }

    public static String getKey() throws Exception {
        String url = "http://auth-server:8081/getLicenceKey";
        LicenceKeySeed request = new LicenceKeySeed();
        request.setIp(MonitorUtil.getIp());
        request.setMac(MonitorUtil.getLocalMac());
        request.setOrgCode("TAOBAO");
        request.setExpireDate("20201008");
        request.setSalt("greedisgood");
        String res = HttpClientUtil.post(url, request);
        JSONObject jsonObject = JSON.parseObject(res);
        return jsonObject.getString("t");
    }
    public static LicenceKeySeed getKeySeed( String licenceKey) throws Exception {
        String url = "http://auth-server:8081/getKeySeed";
        Map map=new HashMap<>();
        map.put("licenceKey",licenceKey);
        String res = HttpClientUtil.post(url, map);
        LicenceKeySeed seed=JSONObject.parseObject(res,LicenceKeySeed.class);
        return seed;
    }
}
