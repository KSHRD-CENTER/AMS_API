package kh.com.kshrd.ams.services.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.kshrd.ams.exceptions.BusinessException;
import kh.com.kshrd.ams.models.WishList;
import kh.com.kshrd.ams.repositories.WishListRepository;
import kh.com.kshrd.ams.services.WishListService;
import kh.com.kshrd.ams.utilities.Pagination;

@Service
public class WishListServiceImpl implements WishListService{

	@Autowired
	private WishListRepository wishListRepository;
	
	@Override
	public WishList saveArticleToWishList(WishList wishList)  throws BusinessException{
		try {
			return wishListRepository.save(wishList);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException();
		}
	}

	@Override
	public boolean removeArticleFromWishList(Long wishListId) throws BusinessException {
		try {
			return wishListRepository.delete(wishListId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException();
		}
	}

	@Override
	public List<WishList> findAllWishLists(Long userId, Pagination pagination)  throws BusinessException{
		try {
			return wishListRepository.findAllByUserId(userId, pagination);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException();
		}
	}
	
	
}
