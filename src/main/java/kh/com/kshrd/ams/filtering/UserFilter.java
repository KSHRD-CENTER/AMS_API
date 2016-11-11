package kh.com.kshrd.ams.filtering;

import java.util.ArrayList;
import java.util.List;

public class UserFilter {

	private String title;
	private String categoryId;
	
	public UserFilter(){
		this.title = "";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public Object[] getFilters() {
		List<Object> filters = new ArrayList<Object>();
		if (title != null) {
			filters.add(title);
		}
		if(categoryId != null){
			filters.add(categoryId);
		}
		return filters.toArray();
	}

}
