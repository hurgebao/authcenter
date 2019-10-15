package com.none.authcenter.exception;

public abstract class BasicException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public  abstract int getCode();
	protected int code;
	public BasicException(String msg){
		super(msg);
	}
	public BasicException(int code,String msg){
		super(msg);
		this.code=code;
	}
}
