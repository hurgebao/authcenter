package com.none.authcenter.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by admin on 2019/10/8.
 */
@Getter
@Setter
public class EntityResponse<T> extends BaseResponse {
    private  T t;
}
