package kh.com.kshrd.ams.forms;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArticleForm {
	
	public static class InsertArticleForm{
		@JsonProperty("TITLE")
		private String title;
		@JsonProperty("DESCRIPTION")
		private String description;
		@JsonProperty("AUTHOR")
		private Long author;
		@JsonProperty("CATEGORY_ID")
		private Long categoryId;
		@JsonProperty("STATUS")
		private String status;
		@JsonProperty("IMAGE")
		private String image;
		
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
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		@Override
		public String toString() {
			return "ArticleForm [title=" + title + ", description=" + description + ", author=" + author + ", categoryId="
					+ categoryId + ", status=" + status + ", image=" + image + "]";
		}
	}
	
	public static class UpdateArticleForm{
		@JsonProperty("TITLE")
		private String title;
		@JsonProperty("DESCRIPTION")
		private String description;
		@JsonProperty("AUTHOR")
		private Long author;
		@JsonProperty("CATEGORY_ID")
		private Long categoryId;
		@JsonProperty("STATUS")
		private String status;
		@JsonProperty("IMAGE")
		private String image;
		
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
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		@Override
		public String toString() {
			return "ArticleForm [title=" + title + ", description=" + description + ", author=" + author + ", categoryId="
					+ categoryId + ", status=" + status + ", image=" + image + "]";
		}
	}

}
