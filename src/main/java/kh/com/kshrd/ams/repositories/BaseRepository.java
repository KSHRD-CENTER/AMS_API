package kh.com.kshrd.ams.repositories;

import java.sql.SQLException;
import java.util.List;

import kh.com.kshrd.ams.utilities.Pagination;

// BaseRepository<Article, Long>
public interface BaseRepository<T, ID, FILTER> {
	//TODO: TO SAVE THE ARTICLE
	public T save(T object) throws SQLException;
	
	//TODO: TO UPDATE ARTICLE BY ID
	public T update(T object) throws SQLException;
	
	//TODO: TO DELETE ARTICLE BY ID
	public boolean delete(ID id) throws SQLException;
	
	//TODO: TO FIND ALL ARTICLES WITH PAGINATION
	public List<T> findAll(Pagination pagination) throws SQLException;
	
	//TODO: TO FIND ALL ARTICLES WITH FILTERING
	public List<T> findAll(FILTER fitler) throws SQLException;
	
	//TODO: TO FIND ALL ARTICLES WITH FILTERING AND PAGINATION
	public List<T> findAll(FILTER fitler, Pagination pagination) throws SQLException;
	
	//TODO: TO FIND ALL ARTICLES
	public List<T> findAll() throws SQLException;
	
	//TODO: TO FIND A ARTICLE BY ID
	public T findOne(ID id) throws SQLException;
	
	public ID count() throws SQLException;

}
