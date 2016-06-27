package kh.com.kshrd.ams.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {

	@JsonProperty("CODE")
	public String code;
	@JsonProperty("MESSAGE")
	public String message;
	
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
	@Override
	public String toString() {
		return "Response [code=" + code + ", message=" + message + "]";
	}
	
}
