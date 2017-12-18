package kh.com.kshrd.ams.forms;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import kh.com.kshrd.ams.models.User;

public class UserForm {
	
	private String email;

	private String name;

	private String password;
	
	private String gender;

	private String telephone;
	
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
		
		private String email;

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
		@JsonIgnore
		private String password;
		
		@JsonIgnore
		private String email;	
	}
	
	public static class FacebookAuthenticationForm extends UserForm {
		
		@JsonProperty("facebook_id")
		private String facebookId;
		
		private String email;

		private String name;

		private String gender;
		
		private String photoUrl;
		
		@JsonIgnore
		private String password;
		
		@JsonIgnore
		private String telephone;
		
		@JsonIgnore
		private CommonsMultipartFile photo;

		public String getFacebookId() {
			return facebookId;
		}

		public void setFacebookId(String facebookId) {
			this.facebookId = facebookId;
		}

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

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getPhotoUrl() {
			return photoUrl;
		}

		public void setPhotoUrl(String photoUrl) {
			this.photoUrl = photoUrl;
		}
	}
	
	public static class SignupForm extends UserForm{

	}
	
}
