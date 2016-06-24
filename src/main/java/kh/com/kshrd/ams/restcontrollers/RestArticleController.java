package kh.com.kshrd.ams.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import kh.com.kshrd.ams.exceptions.BusinessException;
import kh.com.kshrd.ams.filtering.ArticleFilter;
import kh.com.kshrd.ams.models.Article;
import kh.com.kshrd.ams.models.ResponseModel;
import kh.com.kshrd.ams.services.ArticleService;

@RestController
@RequestMapping(value="/v1/api/articles")
@Api("ARTICLE MANAGEMENT API")
public class RestArticleController {
	
	@Autowired
	private ArticleService articleService;

	@RequestMapping(method= RequestMethod.GET)
	@ApiOperation("TODO: TO FIND ALL ARTICLES")
	public ResponseModel<List<Article>> findAllArticles(ArticleFilter filter){
		ResponseModel<List<Article>> responseModel = new ResponseModel<List<Article>>();
		try {
			responseModel.setCode("0000");
			responseModel.setMessage("YOU HAVE BEEN FIND ALL ARTICLES SUCCESSFULLY.");
			responseModel.setData(articleService.findAllArticles(filter));
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return responseModel;
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	@ApiOperation("TODO: TO FIND A ARTICLE BY ID")
	public ResponseModel<Article> findAllArticles(@PathVariable("id") Long id){
		ResponseModel<Article> responseModel = new ResponseModel<Article>();
		try {
			responseModel.setCode("0000");
			responseModel.setMessage("YOU HAVE BEEN FIND A ARTICLE SUCCESSFULLY.");
			responseModel.setData(articleService.findArticleById(id));
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return responseModel;
	}
}
