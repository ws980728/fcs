package com.fcs.utils;

import java.util.HashMap;
import java.util.Map;

public class Msg {

	// 状态码: 200-成功 400-失败
	private int status;
	// 提示信息
	private String message;

	// 用户返回给浏览器的数据
	private Map<String, Object> data = new HashMap<String, Object>();

	public static Msg success() {
		Msg result = new Msg();
		result.setStatus(200);
		result.setMessage("处理成功！");
		return result;
	}

	public static Msg fail() {
		Msg result = new Msg();
		result.setStatus(400);
		result.setMessage("处理失败！");
		return result;
	}

	public Msg add(String key, Object value) {
		this.data.put(key, value);
		return this;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
}
