package com.none.authcenter.dao;

import com.alibaba.fastjson.JSON;
import com.none.authcenter.vo.OrgInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
    @Test
    public void testSelectByCondition()throws Exception{
        OrgInfo orgInfoForSelect=new OrgInfo();
        orgInfoForSelect.setOrgCode("TAOBAO");
        List<OrgInfo> orgInfoList=orgInfoMapper.selectByCondition(orgInfoForSelect);
        System.out.println(orgInfoList);
    }
}