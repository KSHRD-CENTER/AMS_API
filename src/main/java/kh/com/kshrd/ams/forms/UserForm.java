package kh.com.kshrd.ams.forms;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserForm {
	
	@JsonProperty("EMAIL")
	private String email;
	@JsonProperty("NAME")
	private String name;
	@JsonProperty("PASSWORD")
	private String password;
	@JsonProperty("GENDER")
	private String gender;
	@JsonProperty("TELEPHONE")
	private String telephone;
	@JsonProperty("PHOTO")
	private CommonsMultipartFile photo;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public CommonsMultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(CommonsMultipartFile photo) {
		this.photo = photo;
	}
	
	@Override
	public String toString() {
		return "UserForm [email=" + email + ", name=" + name + ", password=" + password + ", gender=" + gender
				+ ", telephone=" + telephone + ", photo=" + photo + "]";
	}
	
	public static class SignInForm{
		@JsonProperty("EMAIL")
		private String email;
		@JsonProperty("PASSWORD")
		private String password;
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		@Override
		public String toString() {
			return "SignInForm [email=" + email + ", password=" + password + "]";
		}
	}
	
	public static class updateUserProfile extends UserForm{
		
	}
	
	public static class SignupForm extends UserForm{

	}
	
}
