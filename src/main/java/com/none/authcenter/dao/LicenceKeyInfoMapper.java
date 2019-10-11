package com.none.authcenter.dao;

import com.none.authcenter.vo.LicenceKeyInfo;
import com.none.authcenter.vo.LicenceKeySeed;

public interface LicenceKeyInfoMapper {
    /**
     *
     * @mbggenerated 2019-10-10
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2019-10-10
     */
    int insert(LicenceKeyInfo record);

    /**
     *
     * @mbggenerated 2019-10-10
     */
    int insertSelective(LicenceKeyInfo record);

    /**
     *
     * @mbggenerated 2019-10-10
     */
    LicenceKeyInfo selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2019-10-10
     */
    LicenceKeyInfo selectBySeed(LicenceKeySeed seed);

    /**
     *
     * @mbggenerated 2019-10-10
     */
    int updateByPrimaryKeySelective(LicenceKeyInfo record);

    /**
     *
     * @mbggenerated 2019-10-10
     */
    int updateByPrimaryKey(LicenceKeyInfo record);
}