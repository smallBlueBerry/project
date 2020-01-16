package com.statics.nwcoinstatics.exception;
/**
 * 服务层异常信息类
 * @author wuyidi
 *
 */
public class ServiceException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	/** 返回报文状态码 **/
	private Integer code;
	
	/** 返回报文消息 **/
	private String message;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public ServiceException(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public ServiceException(String message) {
		super();
		this.message = message;
	}
	
	
	
	
	

}
