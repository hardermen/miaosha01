package com.imooc.miaosha.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.org.apache.bcel.internal.classfile.Code;

public class Result<T> {
	private int code;
	private String msg;
	private T data;

	private Result(int code){
		this.code = code;
	}
	private Result(int code, String msg, T data){
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	private Result(int code, T data) {
		this.code = code;
		this.data = data;
	}
	private Result(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String test(){
		return "测测它出来不？";
	}
	//@JsonIgnore
	//不知上面的有什么作用，所以直接注释掉了，有问题再来修改一下
	@JsonIgnore
	 public boolean isSuccess(){
		return this.code == CodeMsg.SERVER_ERROR.getCode();
	 }



	/**
	 * 成功时候的调用
	 * */
	public static <T> Result<T> createBySuccess(){
		return new Result<T>(CodeMsg.SUCCESS.getCode());
	}
	public static <T> Result<T> createBySuccessMessage(String msg){
		return new Result<T>(CodeMsg.SUCCESS.getCode(),msg);
	}
	public static <T> Result<T> createBySuccessData(T data){
		return new Result<T>(CodeMsg.SUCCESS.getCode(),data);
	}
	public static <T> Result<T> createBySuccessMessageDate(String msg, T data) {
		return new Result<T>(CodeMsg.SUCCESS.getCode(), msg, data);
	}
	/**
	 * 失败时候的调用
	 * */
	public static <T> Result<T> createByError(){
		return new Result<T>(CodeMsg.SERVER_ERROR.getCode());
	}
	public static <T> Result<T> createByErrorMessage(String msg){
		return new Result<T>(CodeMsg.SERVER_ERROR.getCode(),msg);
	}
	public static <T> Result<T> createByErrorData(T data){
		return new Result<T>(CodeMsg.SERVER_ERROR.getCode(),data);
	}
	public static <T> Result<T> createByErrorMessageDate(String msg, T data) {
		return new Result<T>(CodeMsg.SERVER_ERROR.getCode(), msg, data);
	}
//只有成功失败的时候，的确只需要简单的封装不同的result即可，但是，当CodeMsg不止成功和失败，而是不同的信息的时候，就有问题了！
//所以接下来，按照秒杀项目的封装，和上面的不同，根据Code封装result，允许传来一个Code
	public static <T> Result<T> error(CodeMsg codeMsg){
		return new Result<T>(codeMsg);
	}
	private Result(CodeMsg codeMsg){
		if(codeMsg != null){
			this.code = codeMsg.getCode();
			this.msg = codeMsg.getDesc();
		}
	}



	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	public T getData() {
		return data;
	}
}
