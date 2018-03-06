package com.situ.mall.common.response;

import java.io.Serializable;

public class ServerResponse<T> implements Serializable {
	//��ǰ״̬������Ա�ж�״̬��:�ɹ���ʧ�ܡ�δ��¼��û��Ȩ��
	private Integer code;
	//������Ϣ����Ҫ�Ǹ��û�������ʾ��Ϣ��
	private String msg;
	//������
	private Integer count;
	//��̨���ظ�ǰ�˵����
	private T data;

	private ServerResponse() {
	}

	private ServerResponse(Integer code) {
		this.code = code;
	}

	private ServerResponse(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	private ServerResponse(Integer code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	private ServerResponse(Integer code, String msg, Integer count, T data) {
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}

	//ֻ�Ǹ���ǰ̨���ɹ�����״̬
	public static <T> ServerResponse<T> createSuccess() {
		return new ServerResponse<>(ResponseCode.SUCCESS.getCode());
	}

	//����ǰ̨��code,msg
	public static <T> ServerResponse<T> createSuccess(String msg) {
		return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), msg);
	}

	//����ǰ̨��code,msg,data
	public static <T> ServerResponse<T> createSuccess(String msg, T data) {
		return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), msg, data);
	}

	//����ǰ̨��code,msg,count,data
	public static <T> ServerResponse<T> createSuccess(String msg, Integer count, T data) {
		return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), msg, count, data);
	}

	//ֻ�Ǹ���ǰ̨��ʧ������״̬
	public static <T> ServerResponse<T> createError() {
		return new ServerResponse<>(ResponseCode.ERROR.getCode());
	}

	//����ǰ̨��code,msg
	public static <T> ServerResponse<T> createError(String msg) {
		return new ServerResponse<>(ResponseCode.ERROR.getCode(), msg);
	}

	//����ǰ̨��code,msg,data
	public static <T> ServerResponse<T> createError(String msg, T data) {
		return new ServerResponse<>(ResponseCode.ERROR.getCode(), msg, data);
	}

	public boolean isSuccess() {
		return code == ResponseCode.SUCCESS.getCode();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public static void main(String[] args) {
		System.out.println(ResponseCode.ERROR.getCode());
	}
}