package com.imooc.miaosha.result;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
