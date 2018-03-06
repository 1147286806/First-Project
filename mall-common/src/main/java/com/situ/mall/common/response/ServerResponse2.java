package com.situ.mall.common.response;

import java.io.Serializable;

public class ServerResponse2<T> implements Serializable {
	//��ǰ״̬������Ա�ж�״̬��:�ɹ���ʧ�ܡ�δ��¼��û��Ȩ��
	private Integer status;
	//������Ϣ����Ҫ�Ǹ��û�������ʾ��Ϣ��
	private String msg;
	//��̨���ظ�ǰ�˵����
	private T data;

	private ServerResponse2() {
	}

	private ServerResponse2(Integer status) {
		this.status = status;
	}

	private ServerResponse2(Integer status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	private ServerResponse2(Integer status, String msg, T data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	//ֻ�Ǹ���ǰ̨���ɹ�����״̬
	public static <T> ServerResponse2<T> createSuccess() {
		return new ServerResponse2<>(ResponseCode.SUCCESS.getCode());
	}

	//����ǰ̨��status,msg
	public static <T> ServerResponse2<T> createSuccess(String msg) {
		return new ServerResponse2<>(ResponseCode.SUCCESS.getCode(), msg);
	}

	//����ǰ̨��status,msg,data
	public static <T> ServerResponse2<T> createSuccess(String msg, T data) {
		return new ServerResponse2<>(ResponseCode.SUCCESS.getCode(), msg, data);
	}

	//ֻ�Ǹ���ǰ̨��ʧ������״̬
	public static <T> ServerResponse2<T> createError() {
		return new ServerResponse2<>(ResponseCode.ERROR.getCode());
	}

	//����ǰ̨��status,msg
	public static <T> ServerResponse2<T> createError(String msg) {
		return new ServerResponse2<>(ResponseCode.ERROR.getCode(), msg);
	}

	//����ǰ̨��status,msg,data
	public static <T> ServerResponse2<T> createError(String msg, T data) {
		return new ServerResponse2<>(ResponseCode.ERROR.getCode(), msg, data);
	}

	public boolean isSuccess() {
		return status == ResponseCode.SUCCESS.getCode();
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static void main(String[] args) {
		System.out.println(ResponseCode.ERROR.getCode());
	}
}