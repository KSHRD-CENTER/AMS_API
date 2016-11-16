package kh.com.kshrd.ams.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import kh.com.kshrd.ams.exceptions.BusinessException;
import kh.com.kshrd.ams.filtering.CategoryFilter;
import kh.com.kshrd.ams.models.Article;
import kh.com.kshrd.ams.models.Category;
import kh.com.kshrd.ams.models.ResponseList;
import kh.com.kshrd.ams.services.ArticleService;
import kh.com.kshrd.ams.services.CategoryService;
import kh.com.kshrd.ams.utilities.Pagination;

@RestController
@RequestMapping(value="/v1/api/categories")
@Api("CATEGORY MANAGEMENT API")
public class RestCategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ArticleService articleService;

	@RequestMapping(method= RequestMethod.GET)
	@ApiOperation("TODO: TO FIND ALL CATEGORY")
	public ResponseList<Category> findAllCategories(CategoryFilter filter){
		ResponseList<Category> responseModel = new ResponseList<Category>();
		try {
			responseModel.setCode("0000");
			responseModel.setMessage("YOU HAVE BEEN FIND ALL CATEGORIES SUCCESSFULLY.");
			responseModel.setData(categoryService.findAllCategories(filter));
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return responseModel;
	}
	
	@ApiOperation("TODO: TO FIND ALL ARTICLES BY CATEGORY ID")
	@RequestMapping(value="/{id}/articles", method=RequestMethod.GET)
	public ResponseList<Article> findAllArticleByCategoryId(@PathVariable("id") Long id, Pagination pagination){
		ResponseList<Article> response = new ResponseList<Article>();
		try {
			response.setCode("0000");
			response.setMessage("YOU HAVE BEEN FIND ALL CATEGORIES SUCCESSFULLY.");
			response.setData(articleService.findAllArticlesByCategoryId(id, pagination));
			response.setPagination(pagination);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
