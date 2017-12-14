package kh.com.kshrd.ams.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Category {

	private Long id;

	private String name;
	
	@JsonIgnore
	private String status;
	
	@JsonIgnore
	private Category parent;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Category getParent() {
		return parent;
	}
	public void setParent(Category parent) {
		this.parent = parent;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", status=" + status + ", parent=" + parent + "]";
	}
	
}
