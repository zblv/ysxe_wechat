package com.ys.wechat.controller.common;

import java.io.Serializable;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:接口调用结果
 * 调用者判断调用成功之后
 * 根据业务类型取得resultData
 *
 * @author 吕志博
 * @date 2016-5-19 下午1:54:34
 * @version V1.0
 */
public class InvokeResult implements Serializable{
	private static final long serialVersionUID = 1L;
	public static final String STATUS_SUCCESS = "SUCCESS";
	public static final String STATUS_FAILURE = "FAILURE";
	
	public boolean isSuccess(){
		return STATUS_SUCCESS.equals(status);
	}
	public static InvokeResult returnSuccess(Object resultData){
		return new InvokeResult(resultData, STATUS_SUCCESS);
	}
	public static InvokeResult returnError(String msg){
		return new InvokeResult(msg, STATUS_FAILURE);
	}
	
	public InvokeResult() {
	}
	public InvokeResult(String message, String status) {
		this.message = message;
		this.status =  status;
	}
	public InvokeResult(Object resultData, String status) {
		this.resultData = resultData;
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getResultData() {
		return resultData;
	}
	public void setResultData(Object resultData) {
		this.resultData = resultData;
	}
	/**
	 * 接口调用状态
	 */
	private String status;
	/**
	 * 接口调用消息
	 */
	private String message;
	/**
	 * 接口返回数据
	 */
	private Object resultData;
}
