package com.none.authcenter.exception;

import com.none.authcenter.exception.BasicException;

public class HttpErrorCodeException extends BasicException {
	public HttpErrorCodeException(String msg) {
		super(msg);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getCode() {
		return 0;
	}

}
