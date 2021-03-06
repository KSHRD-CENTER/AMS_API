package kh.com.kshrd.ams.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mangofactory.swagger.annotations.ApiIgnore;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;

import kh.com.kshrd.ams.forms.WishListForm;
import kh.com.kshrd.ams.models.Article;
import kh.com.kshrd.ams.models.ResponseList;
import kh.com.kshrd.ams.models.ResponseRecord;
import kh.com.kshrd.ams.models.WishList;
import kh.com.kshrd.ams.services.WishListService;
import kh.com.kshrd.ams.utilities.Pagination;

@RestController
@Api("WISH LIST API MANAGEMENT")
@RequestMapping(value="/v1/api/wishlists")
public class RestWishListController {
	
	@Autowired
	private WishListService wishListService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation("TODO: TO SAVE ARTICLE TO WISH LIST")
	public ResponseRecord<WishList> SaveArticleToWishList(@RequestBody WishListForm.SaveWishList saveWishList){
		ResponseRecord<WishList> response = new ResponseRecord<WishList>();
		try{
			WishList wishList = new WishList();
			Article article = new Article();
			article.setId(saveWishList.getArticleId());
			wishList.setArticle(article);
			wishList.setUserId(saveWishList.getUserId());
			wishList = wishListService.saveArticleToWishList(wishList);
			if(wishList==null){
				response.setCode(9999);
				response.setMessage("FAILURE WHEN SAVE LIST.");
			}else{
				response.setCode(2222);
				response.setMessage("YOU HAVE BEEN SAVE SUCCESSFULLY.");
				response.setData(wishList);				
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return response;
	}
	
	@ApiOperation("TODO: TO LIST ALL WISH LIST BY USER ID")
	@RequestMapping(value="/{userId}", method = RequestMethod.GET)
	@ApiImplicitParams({
	    @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", defaultValue="1",
	            value = "Results page you want to retrieve (1..N)"),
	    @ApiImplicitParam(name = "limit", dataType = "integer", paramType = "query", defaultValue="15",
	            value = "Number of records per page."),
	})
	public ResponseList<WishList> findAllWishListByUserId(@PathVariable("userId") Long userId, @ApiIgnore Pagination pagination){
		ResponseList<WishList> response = new ResponseList<WishList>();
		try{
			List<WishList> list  = wishListService.findAllWishLists(userId, pagination);
			
			if (list == null || list.isEmpty()) {
				response.setCode(9999);
				response.setMessage("NO DATA FOUND.");
			}else {
				response.setCode(2222);
				response.setMessage("YOU HAVE BEEN FOUND SUCCESSFULLY.");
				response.setData(list);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return response;
	}
	
	@ApiOperation("TODO: TO REMOVE ARTICLE FROM WISH LIST")
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseRecord<WishList> removeArticleFromWishList(@PathVariable("id") Long id){
		ResponseRecord<WishList> response = new ResponseRecord<WishList>();
		try{
			WishList wishList = wishListService.removeArticleFromWishList(id);
			if (wishList != null) {
				response.setCode(2222);
				response.setMessage("YOU HAVE BEEN REMOVE SUCCESSFULLY.");
				response.setData(wishList);
			}else{
				response.setCode(9999);
				response.setMessage("FAILURE WHEN REMOVE SAVE LIST.");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return response;
	}

}
