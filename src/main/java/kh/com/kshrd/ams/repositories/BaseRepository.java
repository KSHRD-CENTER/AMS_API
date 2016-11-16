package kh.com.kshrd.ams.repositories;

import java.sql.SQLException;
import java.util.List;

import kh.com.kshrd.ams.models.Article;
import kh.com.kshrd.ams.utilities.Pagination;

// BaseRepository<Article, Long>
public interface BaseRepository<T, ID, FILTER> {
	//TODO: TO SAVE THE ARTICLE
	public T save(T object);
	
	//TODO: TO UPDATE ARTICLE BY ID
	public T update(T object);
	
	//TODO: TO DELETE ARTICLE BY ID
	public T delete(ID id);
	
	//TODO: TO FIND ALL ARTICLES WITH PAGINATION
	public List<T> findAll(Pagination pagination);
	
	//TODO: TO FIND ALL ARTICLES WITH FILTERING
	public List<T> findAll(FILTER filter);
	
	//TODO: TO FIND ALL ARTICLES WITH FILTERING AND PAGINATION
	public List<T> findAll(FILTER filter, Pagination pagination);
	
	//TODO: TO FIND ALL ARTICLES
	public List<T> findAll();
	
	//TODO: TO FIND A ARTICLE BY ID
	public T findOne(ID id);
	
	public ID count();
	
	public ID count(FILTER filter);

}
