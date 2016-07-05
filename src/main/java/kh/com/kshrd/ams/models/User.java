package kh.com.kshrd.ams.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	@JsonProperty("ID")
	private Long id;
	@JsonProperty("NAME")
	private String name;
	@JsonProperty("EMAIL")
	private String email;
	@JsonProperty("GENDER")
	private String gender;
	@JsonProperty("TELEPHONE")
	private String telephone;
	@JsonProperty("STATUS")
	private String status;
	@JsonProperty("PHOTO")
	private String photo;
	@JsonProperty("FACEBOOK_ID")
	private String facebookId;
	@JsonIgnore
	private String password;
	@JsonProperty("IMAGE_URL")
	private String imageUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", gender=" + gender + ", telephone="
				+ telephone + ", status=" + status + ", photo=" + photo + ", facebookId=" + facebookId + ", password="
				+ password + ", imageUrl=" + imageUrl + "]";
	}

	

}
