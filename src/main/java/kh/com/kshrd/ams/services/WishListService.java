package kh.com.kshrd.ams.services;

import java.util.List;

import kh.com.kshrd.ams.exceptions.BusinessException;
import kh.com.kshrd.ams.models.WishList;
import kh.com.kshrd.ams.utilities.Pagination;

public interface WishListService {

	//TODO: TO SAVE ARTICEL TO WISH LIST
	public WishList saveArticleToWishList(WishList wishList) throws BusinessException;
	
	//TODO: TO REMOVE ARTICLE FROM WISH LIST
	public boolean removeArticleFromWishList(Long wishListId) throws BusinessException;
	
	//TODO: TO LIST ALL WISH LIST BY USER ID
	public List<WishList> findAllWishLists(Long userId, Pagination pagination) throws BusinessException;
}
