package com.none.authcenter.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * Created by admin on 2019/10/8.
 */
@Getter
@Setter
public class LicenceKeySeed  extends BaseVO {
    @ApiModelProperty(value = "ip",example = "172.16.3.196",position = 3)
    @Pattern(regexp="[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}",message = "ip格式错误")
    @NotEmpty(message = "ip不能为空")
    private String ip;
    /**
     * mac地址
     */
    @NotEmpty(message = "mac不能为空")
    @ApiModelProperty(value = "mac地址",example = "B0-83-FE-70-3F-1F")
    private String mac;
    /**
     * 系统代码
     */
    @NotEmpty(message = "系统代码不能为空")
    @ApiModelProperty(value = "系统代码",example = "TAOBAO")
    private String orgCode;
    /**
     * 到期日
     */
    @ApiModelProperty(value="到期日",example = "20201008")
    @NotEmpty(message = "到期日不能为空")
    private String expireDate;
    /**
     *混淆分子
     */
    @ApiModelProperty(value="混淆分子",example = "greedisgood")
    @NotEmpty(message = "丢东西了")
    private String salt;
}
