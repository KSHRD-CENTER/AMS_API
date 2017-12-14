package kh.com.kshrd.ams.models;


public class Response {

	public String code;

	public String message;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		if("".equals(this.message)){
			if("0000".equals(this.code)){
				this.message = "SUCCESSFULLY.";
			}else if("9999".equals(this.code)){
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
