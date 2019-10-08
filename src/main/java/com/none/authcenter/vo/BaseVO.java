package com.none.authcenter.vo;

import com.alibaba.fastjson.JSON;

/**
 * Created by admin on 2019/9/26.
 */
public class BaseVO {
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
