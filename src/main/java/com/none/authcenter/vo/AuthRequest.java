package com.none.authcenter.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by admin on 2019/9/26.
 */
@Getter
@Setter
public class AuthRequest extends BaseVO {
    /**
     * 认证客户端本地发起请求时间 yyyyMMddHHmmss
     */
    @ApiModelProperty(value = "认证发起时间",example = "20191008155212",position=1)
    @NotNull(message = "认证发起时间不能为空")
    private String authTime;
    /**
     * 私有代码
     */
    @ApiModelProperty(value = "认证方代码",example = "TAOBAO",position=2)
    @NotNull(message = "认证方代码不能为空")
    private String privateCode;
    /**
     * 服务器ip
     */
    @ApiModelProperty(value = "ip",example = "172.16.3.196",position = 3)
    @Pattern(regexp="[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}",message = "ip格式错误")
    private String ip;
    /**
     * 服务器mac
     */
    @ApiModelProperty(value = "mac",example = "B0-83-FE-70-3F-1F",position =4 )
    @NotNull(message = "mac不能为空")
    private String mac;
    /**
     *授权码
     * TAOBAOB083FE703F1F20201008
     * 私有代码+机器MAC+到期日 加密
     *
     */
    @ApiModelProperty(value = "授权码",example = "U9zuh4A6F9gxDoSnLN1rhteOvc1NQLM+oIT5bJeeKZY=",position = 5)
    @NotNull(message = "授权码不能为空")
    private String licenceKey;
    /**
     * 剩余天数
     */
    @ApiModelProperty(value = "剩余天数",example = "365",position = 6)
    @NotNull(message = "剩余天数不能为空")
    private Integer remainDay;
    /**
     * 到期日(yyyyMMdd)
     */
    @ApiModelProperty(value = "到期日",example = "20201008",position = 7)
    @NotNull(message = "到期日不能为空")
    private String expireDate;
    /**
     * 签名串
     */
    @ApiModelProperty(value = "签名串",example = "vYybJCklaKtUdTnBmmZFac1wF5MIyXBNWu0MxA6r59dXg123X3NV1gdYlKRERjttc3qMoqrrr9pkEzTBcyC/4ar6fpQ0d3vHtbOjDIXUWDBturyRoBnvZT0I9I+8VWEoU90CVzWIMG2zKaFgIscTLR2+0zswVJ3YT0YB6x3hePL2Vh9NP9aWXCpsZRQMFUFdqgSIzXeqaWjxwSpLP/NYoid7b24vpRD139HgdULCHMjjT27WfWZNDi6j0hD8FStzsigCcM6/7DA=",position = 8)
    @NotNull(message = "签名串不能为空")
    private String data;

}
