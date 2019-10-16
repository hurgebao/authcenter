package com.none.authcenter.dao;

import com.none.authcenter.vo.AuthHistory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by admin on 2019/10/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthHistoryMapperTest {
    @Autowired
    private  AuthHistoryMapper authHistoryMapper;
    @Test
    public void testDeleteByPrimaryKey() throws Exception {

    }

    @Test
    public void testInsert() throws Exception {
        AuthHistory record=new AuthHistory();
        record.setLicenceKey("123");
        record.setLicenceKeyId(2);
        record.setResult("认证失败");
        record.setResultCode("0001");
        authHistoryMapper.insert(record);
    }

    @Test
    public void testInsertSelective() throws Exception {
        AuthHistory record=new AuthHistory();
        record.setLicenceKey("123");
        record.setLicenceKeyId(2);
        record.setResult("认证失败");
        record.setResultCode("0001");
        authHistoryMapper.insertSelective(record);
    }

    @Test
    public void testSelectByPrimaryKey() throws Exception {
        AuthHistory auth=authHistoryMapper.selectByPrimaryKey(1);
        System.out.println(auth);
    }

    @Test
    public void testUpdateByPrimaryKeySelective() throws Exception {
        AuthHistory record=new AuthHistory();
        record.setLicenceKey("testUpdateByPrimaryKeySelective");
        record.setLicenceKeyId(2);
        record.setResult("认证失败");
        record.setResultCode("0001");
        record.setId(1);
        authHistoryMapper.updateByPrimaryKeySelective(record);
    }

    @Test
    public void testUpdateByPrimaryKey() throws Exception {
        AuthHistory record=new AuthHistory();
        record.setLicenceKey("testUpdateByPrimaryKey");
        record.setLicenceKeyId(2);
        record.setResult("认证失败");
        record.setResultCode("0001");
        record.setId(2);
        authHistoryMapper.updateByPrimaryKey(record);

    }
}