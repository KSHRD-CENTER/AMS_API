package kh.com.kshrd.ams.forms;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WishListForm {

	public static class SaveWishList{
		@JsonProperty("user_id")
		private Long userId;
		@JsonProperty("article_id")
		private Long articleId;
		
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public Long getArticleId() {
			return articleId;
		}
		public void setArticleId(Long articleId) {
			this.articleId = articleId;
		}
		@Override
		public String toString() {
			return "SaveWishList [userId=" + userId + ", articleId=" + articleId + "]";
		}
	}
}
