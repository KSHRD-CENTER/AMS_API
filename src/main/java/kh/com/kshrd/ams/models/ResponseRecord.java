package kh.com.kshrd.ams.models;

public class ResponseRecord<T> extends Response {

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
