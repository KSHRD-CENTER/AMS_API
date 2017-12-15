package kh.com.kshrd.ams.forms;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArticleForm {
	
	public static class InsertArticleForm{
		
		private String title;
		
		private String description;
		
		@JsonProperty("author_id")
		private Long authorId;
		
		@JsonProperty("category_id")
		private Long categoryId;
		
		private String status;
		
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
		public Long getAuthorId() {
			return authorId;
		}
		public void setAuthorId(Long authorId) {
			this.authorId = authorId;
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
		
	}
	
	public static class UpdateArticleForm{
		
		private String title;
		
		private String description;
		
		@JsonProperty("author_id")
		private Long authorId;
		
		@JsonProperty("category_id")
		private Long categoryId;
		
		private String status;
		
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
		public Long getAuthorId() {
			return authorId;
		}
		public void setAuthorId(Long authorId) {
			this.authorId = authorId;
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
			return "UpdateArticleForm [title=" + title + ", description=" + description + ", authorId=" + authorId
					+ ", categoryId=" + categoryId + ", status=" + status + ", image=" + image + ", getTitle()="
					+ getTitle() + ", getDescription()=" + getDescription() + ", getAuthor()=" + getAuthorId()
					+ ", getCategoryId()=" + getCategoryId() + ", getStatus()=" + getStatus() + ", getImage()="
					+ getImage() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
					+ super.toString() + "]";
		}
	}

}
