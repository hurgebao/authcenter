package com.none.authcenter.vo;

import java.util.Date;

public class LicenceKeyInfo extends  BaseVO{
    /**
     * 主键
     */
    private Integer id;

    /**
     * 系统代码
     */
    private String orgCode;

    /**
     * 到期日
     */
    private String expireDate;

    /**
     * ip
     */
    private String ip;

    /**
     * mac地址
     */
    private String mac;

    /**
     * 混淆分子
     */
    private String salt;

    /**
     * 许可序列号
     */
    private String licenceKeySeed;

    /**
     * 许可序列号
     */
    private String licenceKey;

    /**
     * 状态
     */
    private String status;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最近更新时间
     */
    private Date updateTime;

    /**
     * 主键
     * @return id 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 系统代码
     * @return org_code 系统代码
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * 系统代码
     * @param orgCode 系统代码
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * 到期日
     * @return expire_date 到期日
     */
    public String getExpireDate() {
        return expireDate;
    }

    /**
     * 到期日
     * @param expireDate 到期日
     */
    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate == null ? null : expireDate.trim();
    }

    /**
     * ip
     * @return ip ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * ip
     * @param ip ip
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * mac地址
     * @return mac mac地址
     */
    public String getMac() {
        return mac;
    }

    /**
     * mac地址
     * @param mac mac地址
     */
    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    /**
     * 混淆分子
     * @return salt 混淆分子
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 混淆分子
     * @param salt 混淆分子
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 许可序列号
     * @return licence_key_seed 许可序列号
     */
    public String getLicenceKeySeed() {
        return licenceKeySeed;
    }

    /**
     * 许可序列号
     * @param licenceKeySeed 许可序列号
     */
    public void setLicenceKeySeed(String licenceKeySeed) {
        this.licenceKeySeed = licenceKeySeed == null ? null : licenceKeySeed.trim();
    }

    /**
     * 许可序列号
     * @return licence_key 许可序列号
     */
    public String getLicenceKey() {
        return licenceKey;
    }

    /**
     * 许可序列号
     * @param licenceKey 许可序列号
     */
    public void setLicenceKey(String licenceKey) {
        this.licenceKey = licenceKey == null ? null : licenceKey.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 最近更新时间
     * @return update_time 最近更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 最近更新时间
     * @param updateTime 最近更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}