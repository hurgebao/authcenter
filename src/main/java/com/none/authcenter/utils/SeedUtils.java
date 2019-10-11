package com.none.authcenter.utils;

import com.none.authcenter.vo.LicenceKeyInfo;
import com.none.authcenter.vo.LicenceKeySeed;

/**
 * Created by admin on 2019/10/9.
 */
public class SeedUtils {
    /**
     * 将许可证信息拼成字符串
     * @param seed
     * @return
     */
    public static String generateHeader(LicenceKeySeed seed ){
        return  seed.getOrgCode()+seed.getIp()+seed.getMac()+seed.getExpireDate() + seed.getSalt();

    }

    /**
     * 获取许可证各字符串的长度
     * @param seed
     * @return
     */
    public static String generateHeaderLength(LicenceKeySeed seed){
        return StringUtils.getLength2(seed.getOrgCode())
                +StringUtils.getLength2(seed.getIp())
                +StringUtils.getLength2(seed.getMac())
                +StringUtils.getLength2(seed.getExpireDate())
                +StringUtils.getLength2(seed.getSalt());

    }

    /**
     * 根据字符串解析许可证信息
     * @param keystr
     * @return
     */
    public static LicenceKeySeed getLicenceKeySeed(String keystr){
        if(StringUtils.trim(keystr)==null || keystr.length()<=10){
            return null;
        }
        int orgCodeLength=Integer.valueOf(keystr.substring(0, 2));
        int ipLength=Integer.valueOf(keystr.substring(2, 4));
        int macLength=Integer.valueOf(keystr.substring(4, 6));
        int expireDateLength=Integer.valueOf(keystr.substring(6, 8));
        int saltLength=Integer.valueOf(keystr.substring(8, 10));
        int length=10+orgCodeLength+ipLength+macLength+expireDateLength+saltLength;
        if(length!=keystr.length()){
            return null;
        }
        int position=10;
        int endposition=position+orgCodeLength;
        String orgCode=keystr.substring(position,endposition);
        position=endposition;
        endposition=position+ipLength;
        String ip=keystr.substring(position,endposition);
        position=endposition;
        endposition=position+macLength;
        String mac=keystr.substring(position,endposition);
        position=endposition;
        endposition=position+expireDateLength;
        String expireDate=keystr.substring(position,endposition);
        position=endposition;
        endposition=position+saltLength;
        String salt=keystr.substring(position,endposition);
        LicenceKeySeed seed=new LicenceKeySeed();
        seed.setExpireDate(expireDate);
        seed.setIp(ip);
        seed.setMac(mac);
        seed.setOrgCode(orgCode);
        seed.setSalt(salt);
        return seed;
    }
    public  static void main(String[] args){
        String keystr="0612120811TAOBAO172.16.3.196B083FE703F1F20201008greedisgood";
        LicenceKeySeed seed =getLicenceKeySeed(keystr);
        System.out.println("seed:"+seed);
    }
    public static boolean assertEquels(LicenceKeySeed seed, LicenceKeyInfo licenceK) {
        try {

            if(seed.getMac().equals(licenceK.getMac())
                    && seed.getIp().equals(licenceK.getIp())
                    && seed.getSalt().equals(licenceK.getSalt())
                    && seed.getExpireDate().equals(licenceK.getExpireDate())
                    && seed.getOrgCode().equals(licenceK.getOrgCode())
                    ){
                return true;
            }
        }catch (Exception e){
        }
        return false;
    }

}
