package com.imooc.miaosha.result;

public enum  CodeMsg {
	//通用异常
    SUCCESS(0, "success"),
    SERVER_ERROR(500100, "服务端异常");
	//登录模块 5002XX

	//商品模块 5003XX

	//订单模块 5004XX

	//秒杀模块 5005XX

	private int code;
	//下面的这个desc和Result包装类的msg有不同，这个是状态码的自我描述，而那个是真正的返回信息！！！
	private String desc;

	private CodeMsg(int code, String msg) {
		this.code = code;
		this.desc = msg;
	}
	public int getCode() {
		return code;
	}
	public String getDesc() {
		return desc;
	}
}
