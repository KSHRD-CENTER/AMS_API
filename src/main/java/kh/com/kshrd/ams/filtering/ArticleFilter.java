package kh.com.kshrd.ams.filtering;

import java.util.ArrayList;
import java.util.List;

public class ArticleFilter {

	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Object[] getFilters() {
		List<Object> filters = new ArrayList<Object>();
		if (title != null) {
			filters.add(title);
		}
		return filters.toArray();
	}

}
