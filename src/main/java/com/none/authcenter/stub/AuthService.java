package com.none.authcenter.stub;

import com.none.authcenter.vo.AuthRequest;
import com.none.authcenter.vo.BaseResponse;

/**
 * Created by admin on 2019/10/8.
 */
public interface AuthService {
    public BaseResponse auth( AuthRequest request);
}
