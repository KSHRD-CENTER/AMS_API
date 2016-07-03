package kh.com.kshrd.ams.utilities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import kh.com.kshrd.ams.exceptions.CustomGenericException;

public class Pagination implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("PAGE")
	private int page;

	@JsonProperty("LIMIT")
	private int limit;

	@JsonProperty("TOTAL_COUNT")
	private Long totalCount;

	@JsonProperty("TOTAL_PAGES")
	private int totalPages;

	public Pagination() {
		this(1, 15, 0L, 0);
	}

	public Pagination(int page, int limit) {
		this.page = page;
		this.limit = limit;
		this.totalCount = 0L;
		this.totalPages = 0;
	}

	public Pagination(int page, int limit, Long totalCount, int totalPages) {
		this.page = page;
		this.limit = limit;
		this.totalCount = totalCount;
		this.totalPages = totalPages;
	}

	public int getPage() {
		return page;
	}

	public int totalPages() {
		return (int) Math.ceil((double) this.totalCount / limit);

	}

	public int nextPage() {
		return this.page + 1;
	}

	public int previousPage() {
		return this.page - 1;
	}

	public boolean hasNextPage() {
		return this.nextPage() <= this.totalPages() ? true : false;
	}

	public boolean hasPreviousPage() {
		return this.previousPage() >= 1 ? true : false;
	}

	public int offset() {
		return (this.page - 1) * limit;
	}

	public void setPage(int currentPage) {
		this.page = currentPage;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
		this.totalPages = totalPages();
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

}
