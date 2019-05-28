package com.fcs.utils;

import java.util.HashMap;
import java.util.Map;

public class Msg {

	// ״̬��: 200-�ɹ� 400-ʧ��
	private int status;
	// ��ʾ��Ϣ
	private String message;

	// �û����ظ������������
	private Map<String, Object> data = new HashMap<String, Object>();

	public static Msg success() {
		Msg result = new Msg();
		result.setStatus(200);
		result.setMessage("����ɹ���");
		return result;
	}

	public static Msg fail() {
		Msg result = new Msg();
		result.setStatus(400);
		result.setMessage("����ʧ�ܣ�");
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
