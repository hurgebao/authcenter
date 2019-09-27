package com.none.authcenter.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by admin on 2019/9/26.
 */
@Getter
@Setter
public class AuthResponse extends BasicVO {
    private String code;
    private String msg;
}
