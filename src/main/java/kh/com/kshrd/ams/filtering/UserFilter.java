package kh.com.kshrd.ams.filtering;

import java.util.ArrayList;
import java.util.List;

public class UserFilter {

	private String name;
	
	public UserFilter(){
		this.name = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Object[] getFilters() {
		List<Object> filters = new ArrayList<Object>();
		if (name != null) {
			filters.add(name);
		}

		return filters.toArray();
	}

}
