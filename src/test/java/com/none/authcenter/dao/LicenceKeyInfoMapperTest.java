package com.none.authcenter.dao;

import com.none.authcenter.vo.LicenceKeyInfo;
import com.none.authcenter.vo.LicenceKeySeed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by admin on 2019/10/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LicenceKeyInfoMapperTest {
    @Autowired
    private LicenceKeyInfoMapper licenceKeyInfoMapper;
    @Test
    public void testDeleteByPrimaryKey() throws Exception {

    }

    @Test
    public void testInsert() throws Exception {

    }

    @Test
    public void testInsertSelective() throws Exception {

    }

    @Test
    public void testSelectByPrimaryKey() throws Exception {

    }

    @Test
    public void testSelectBySeed() throws Exception {
        LicenceKeySeed seed=new LicenceKeySeed();
        seed.setIp("172.16.3.196");
        seed.setSalt("greedisgood");
        seed.setOrgCode("TAOBAO");
        seed.setMac("B0-83-FE-70-3F-1F");
        seed.setExpireDate("20201008");
        LicenceKeyInfo licenceKeyInfo = licenceKeyInfoMapper.selectBySeed(seed);
        System.out.println("licenceKeyInfo"+licenceKeyInfo);
    }

    @Test
    public void testUpdateByPrimaryKeySelective() throws Exception {

    }

    @Test
    public void testUpdateByPrimaryKey() throws Exception {

    }
}