package com.none.authcenter.utils;

import com.none.authcenter.vo.LicenceKeySeed;

/**
 * Created by admin on 2019/10/9.
 */
public class SeedUtils {
    public static String generateHeader(LicenceKeySeed seed ){
        return  seed.getPrivateCode()+seed.getMac().replaceAll("-", "").toUpperCase()+seed.getExpireDate()+seed.getSalt();

    }
    public static String generateHeaderLength(LicenceKeySeed seed){
        return StringUtils.getLength(seed.getPrivateCode())
                +StringUtils.getLength(seed.getMac().replaceAll("-", "").toUpperCase())
                +StringUtils.getLength(seed.getExpireDate())
                +StringUtils.getLength(seed.getSalt());

    }
}
