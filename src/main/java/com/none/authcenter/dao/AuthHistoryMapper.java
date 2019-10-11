package com.none.authcenter.dao;

import com.none.authcenter.vo.AuthHistory;

public interface AuthHistoryMapper {
    /**
     *
     * @mbggenerated 2019-10-10
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2019-10-10
     */
    int insert(AuthHistory record);

    /**
     *
     * @mbggenerated 2019-10-10
     */
    int insertSelective(AuthHistory record);

    /**
     *
     * @mbggenerated 2019-10-10
     */
    AuthHistory selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2019-10-10
     */
    int updateByPrimaryKeySelective(AuthHistory record);

    /**
     *
     * @mbggenerated 2019-10-10
     */
    int updateByPrimaryKey(AuthHistory record);
}