package kh.com.kshrd.ams.models;


public class Response {

	public int code;

	public String message;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		if("".equals(this.message)){
			if(2222 == this.code){
				this.message = "SUCCESSFULLY.";
			}else if(9999 == this.code){
				this.message = "FAILURE.";
			}			
		}
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
