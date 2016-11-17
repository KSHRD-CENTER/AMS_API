package kh.com.kshrd.ams.repositories;

import java.sql.SQLException;
import java.util.List;

import kh.com.kshrd.ams.models.WishList;
import kh.com.kshrd.ams.utilities.Pagination;

public interface WishListRepository {
	
	//TODO: TO SAVE WISH LIST
	public WishList save(WishList wishList);
	
	//TODO: TO REMOVE THE WISH LIST
	public WishList delete(Long id);
	
	//TODO: TO LIST ALL WISH LIST BY USER ID
	public List<WishList> findAllByUserId(Long id, Pagination pagination);
	
	public WishList findOne(Long id) throws SQLException;
	
	//TODO: TO COUNT WISH LIST BY UserId
	public Long count(Long id);

}
