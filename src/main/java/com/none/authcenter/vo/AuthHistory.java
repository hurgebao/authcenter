package com.none.authcenter.vo;

import java.util.Date;

public class AuthHistory extends  BaseVO{
    /**
     * 主键
     */
    private Integer id;

    /**
     * 许可证id
     */
    private Integer licenceKeyId;

    /**
     * 许可证
     */
    private String licenceKey;

    /**
     * 备注
     */
    private String remark;

    /**
     * 认证结果
     */
    private String result;
    /**
     * 认证结果
     */
    private String resultCode;

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
     * 许可证id
     * @return licence_key_id 许可证id
     */
    public Integer getLicenceKeyId() {
        return licenceKeyId;
    }

    /**
     * 许可证id
     * @param licenceKeyId 许可证id
     */
    public void setLicenceKeyId(Integer licenceKeyId) {
        this.licenceKeyId = licenceKeyId;
    }

    public String getLicenceKey() {
        return licenceKey;
    }

    public void setLicenceKey(String licenceKey) {
        this.licenceKey = licenceKey;
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 认证结果
     * @return result 认证结果
     */
    public String getResult() {
        return result;
    }

    /**
     * 认证结果
     * @param result 认证结果
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
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