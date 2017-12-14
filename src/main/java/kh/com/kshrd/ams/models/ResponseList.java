package kh.com.kshrd.ams.models;

import java.util.List;


import kh.com.kshrd.ams.utilities.Pagination;

public class ResponseList<T> extends Response {
	
	private List<T> data;

	private Pagination pagination;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	@Override
	public String toString() {
		return "ResponseList [data=" + data + ", pagination=" + pagination + "]";
	}
	
}
