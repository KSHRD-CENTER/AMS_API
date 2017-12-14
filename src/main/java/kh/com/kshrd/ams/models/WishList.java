package kh.com.kshrd.ams.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WishList {

	private Long id;
	
	@JsonProperty("user_id")
	private Long userId;

	private Article article;
	
	@JsonProperty("created_date")
	private String createdDate;

	private String status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
}
