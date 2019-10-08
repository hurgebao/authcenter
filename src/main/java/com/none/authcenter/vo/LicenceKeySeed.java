package com.none.authcenter.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created by admin on 2019/10/8.
 */
@Getter
@Setter
public class LicenceKeySeed  extends BaseVO {
    /**
     * mac地址
     */
    @NotNull(message = "mac不能为空")
    @ApiModelProperty(value = "mac地址",example = "B0-83-FE-70-3F-1F")
    private String mac;
    /**
     * 系统代码
     */
    @NotNull(message = "系统代码不能为空")
    @ApiModelProperty(value = "系统代码",example = "TAOBAO")
    private String privateCode;
    /**
     * 到期日
     */
    @ApiModelProperty(value="到期日",example = "20201008")
    @NotNull(message = "到期日不能为空")
    private String expireDate;
    /**
     *混淆分子
     */
    @ApiModelProperty(value="混淆分子",example = "greedisgood")
    @NotNull(message = "丢东西了")
    private String salt;
}
