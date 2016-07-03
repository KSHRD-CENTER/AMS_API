package kh.com.kshrd.ams.forms;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArticleForm {

	@JsonProperty("TITLE")
	private String title;
	@JsonProperty("DESCRIPTION")
	private String description;
	@JsonProperty("CREATED_DATE")
	private String createdDate;
	@JsonProperty("AUTHOR")
	private Long author;
	@JsonProperty("CATEGORY_ID")
	private Long categoryId;
	@JsonProperty("STATUS")
	private String status;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public Long getAuthor() {
		return author;
	}
	public void setAuthor(Long author) {
		this.author = author;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
