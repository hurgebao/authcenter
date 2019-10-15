package com.none.authcenter.utils;

import com.none.authcenter.vo.LicenceKeySeed;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by admin on 2019/10/14.
 */
public class AuthUtilTest {

    @Test
    public void testAuth() throws Exception {
        try {
            String auth = AuthUtil.auth();
            System.out.println("auth"+auth);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetKey() throws Exception {
        try {
            String key=AuthUtil.getKey();
            System.out.println("key"+key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testGetKeySeed() throws Exception {
        try {
            String licenceKey="t/cxhmtlzI9JnJfUBIf5R/gZ/Z22Ys1nTSilbLzRpx2qBIjNd6ppaN/0uxIuAfoEQMHGIO6bWFahPyVx08hKCqEqC8SYzwWj";
            LicenceKeySeed key=AuthUtil.getKeySeed(licenceKey);
            System.out.println("key"+key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}