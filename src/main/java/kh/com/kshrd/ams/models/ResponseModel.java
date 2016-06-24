package kh.com.kshrd.ams.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseModel<T> {

	@JsonProperty("CODE")
	public String code;
	@JsonProperty("MESSAGE")
	public String message;
	@JsonProperty("DATA")
	public T data;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseModel [code=" + code + ", message=" + message + ", data=" + data + "]";
	}
	
}
