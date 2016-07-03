package kh.com.kshrd.ams.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseRecord<T> extends Response {

	@JsonProperty("DATA")
	public T data;
	
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
