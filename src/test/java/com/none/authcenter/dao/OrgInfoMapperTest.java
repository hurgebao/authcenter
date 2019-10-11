package com.none.authcenter.dao;

import com.alibaba.fastjson.JSON;
import com.none.authcenter.vo.OrgInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by admin on 2019/10/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrgInfoMapperTest {
    @Autowired
    private OrgInfoMapper orgInfoMapper;
    @Test
    public void testDeleteByPrimaryKey() throws Exception {

    }

    @Test
    public void testInsertSelective() throws Exception {

    }

    @Test
    public void testSelectByPrimaryKey() throws Exception {
        OrgInfo orgInfo = orgInfoMapper.selectByPrimaryKey(1);
        System.out.println(JSON.toJSONString(orgInfo));
    }


    @Test
    public void testUpdateByPrimaryKeySelective() throws Exception {

    }
}