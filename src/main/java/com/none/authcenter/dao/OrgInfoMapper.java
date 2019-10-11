package com.none.authcenter.dao;

import com.none.authcenter.vo.OrgInfo;

public interface OrgInfoMapper {
    /**
     *
     * @mbggenerated 2019-10-10
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2019-10-10
     */
    int insert(OrgInfo record);

    /**
     *
     * @mbggenerated 2019-10-10
     */
    int insertSelective(OrgInfo record);

    /**
     *
     * @mbggenerated 2019-10-10
     */
    OrgInfo selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2019-10-10
     */
    int updateByPrimaryKeySelective(OrgInfo record);

    /**
     *
     * @mbggenerated 2019-10-10
     */
    int updateByPrimaryKey(OrgInfo record);
}