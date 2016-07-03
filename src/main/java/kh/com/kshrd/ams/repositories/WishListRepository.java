package kh.com.kshrd.ams.repositories;

import java.sql.SQLException;
import java.util.List;

import kh.com.kshrd.ams.models.WishList;
import kh.com.kshrd.ams.utilities.Pagination;

public interface WishListRepository {
	
	//TODO: TO SAVE WISH LIST
	public WishList save(WishList wishList) throws SQLException;
	
	//TODO: TO REMOVE THE WISH LIST
	public boolean delete(Long id) throws SQLException;
	
	//TODO: TO LIST ALL WISH LIST BY USER ID
	public List<WishList> findAllByUserId(Long id, Pagination pagination) throws SQLException;
	
	public WishList findOne(Long id) throws SQLException;
	
	//TODO: TO COUNT WISH LIST BY UserId
	public Long count(Long id) throws SQLException;

}
