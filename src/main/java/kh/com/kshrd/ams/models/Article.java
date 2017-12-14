package kh.com.kshrd.ams.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Article {

	private Long id;
	
	private String title;
	
	private String description;
	
	@JsonProperty("created_date")
	private String createdDate;
	
	private User author;
	
	private String status;
	
	private Category category;
	
	@JsonProperty("image_url")
	private String image;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", description=" + description + ", createdDate="
				+ createdDate + ", author=" + author + ", status=" + status + ", category=" + category + ", image="
				+ image + "]";
	}
	
	
}
