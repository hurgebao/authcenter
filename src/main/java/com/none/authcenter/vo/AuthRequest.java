package com.none.authcenter.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by admin on 2019/9/26.
 */
@Getter
@Setter
public class AuthRequest extends BasicVO{
    /**
     * 认证客户端本地发起请求时间
     */
    private String authTime;
    private String ip;
    private String mac;
    private String licenceKey;
    private String data;

}
