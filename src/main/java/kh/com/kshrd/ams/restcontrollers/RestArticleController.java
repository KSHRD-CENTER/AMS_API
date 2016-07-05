package kh.com.kshrd.ams.restcontrollers;

import javax.servlet.http.HttpServletRequest;

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

import kh.com.kshrd.ams.exceptions.BusinessException;
import kh.com.kshrd.ams.filtering.ArticleFilter;
import kh.com.kshrd.ams.forms.ArticleForm;
import kh.com.kshrd.ams.models.Article;
import kh.com.kshrd.ams.models.Category;
import kh.com.kshrd.ams.models.Response;
import kh.com.kshrd.ams.models.ResponseList;
import kh.com.kshrd.ams.models.ResponseRecord;
import kh.com.kshrd.ams.models.User;
import kh.com.kshrd.ams.services.ArticleService;
import kh.com.kshrd.ams.services.UploadService;
import kh.com.kshrd.ams.utilities.Pagination;

@RestController
@RequestMapping(value="/v1/api/articles")
@Api("ARTICLE MANAGEMENT API")
public class RestArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private UploadService uploadService;

	@RequestMapping(method= RequestMethod.GET)
	@ApiOperation("TODO: TO FIND ALL ARTICLES")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "title", dataType = "string", paramType = "query", defaultValue="",
	            value = "Title of the news"),
	    @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", defaultValue="1",
	            value = "Results page you want to retrieve (1..N)"),
	    @ApiImplicitParam(name = "limit", dataType = "integer", paramType = "query", defaultValue="15",
	            value = "Number of records per page."),
	})
	public ResponseList<Article> findAllArticles(@ApiIgnore ArticleFilter filter, @ApiIgnore Pagination pagination){
		System.err.println("PAGE NUMBER ==> " + pagination.getPage());
		ResponseList<Article> responseModel = new ResponseList<Article>();
		try {
			responseModel.setCode("0000");
			responseModel.setMessage("YOU HAVE BEEN FIND ALL ARTICLES SUCCESSFULLY.");
			responseModel.setData(articleService.findAllArticles(filter, pagination));
			responseModel.setPagination(pagination);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return responseModel;
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	@ApiOperation("TODO: TO FIND A ARTICLE BY ID")
	public ResponseRecord<Article> findAllArticles(@PathVariable("id") Long id){
		ResponseRecord<Article> responseModel = new ResponseRecord<Article>();
		try {
			responseModel.setCode("0000");
			responseModel.setMessage("YOU HAVE BEEN FIND A ARTICLE SUCCESSFULLY.");
			responseModel.setData(articleService.findArticleById(id));
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return responseModel;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation("TODO: TO REGISTER A NEW ARTICLE")
	public Response addNewArticle(@RequestBody ArticleForm.InsertArticleForm form, HttpServletRequest request){
		Response responseModel = new Response();
		try {
			responseModel.setCode("0000");
			responseModel.setMessage("YOU HAVE BEEN ADD NEW ARTICLE SUCCESSFULLY.");
			Article article = new Article();
			User user = new User();
			user.setId(form.getAuthor());
			article.setAuthor(user);
			article.setTitle(form.getTitle());
			article.setDescription(form.getDescription());
			article.setImage(uploadService.uploadMultipart(form.getImage(), request));
			
			Category category = new Category();
			category.setId(form.getCategoryId());
			
			article.setCategory(category);
			articleService.addNewArticle(article);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return responseModel;
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	@ApiOperation("TODO: TO UPDATE A ARTICLE BY ID")
	public Response deleteArticle(@PathVariable("id") Long id, @RequestBody ArticleForm.UpdateArticleForm form, HttpServletRequest request ){
		Response responseModel = new Response();
		try {
			Article article = new Article();
			article.setId(id);
			User user = new User();
			user.setId(form.getAuthor());
			article.setAuthor(user);
			article.setTitle(form.getTitle());
			article.setDescription(form.getDescription());
			article.setImage(uploadService.uploadMultipart(form.getImage(), request));
			
			Category category = new Category();
			category.setId(form.getCategoryId());
			
			article.setCategory(category);
			articleService.updateArticle(article);
			responseModel.setCode("0000");
			responseModel.setMessage("YOU HAVE BEEN UPDATED THE ARTICLE SUCCESSFULLY.");
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return responseModel;
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	@ApiOperation("TODO: TO DELETE A ARTICLE BY ID")
	public Response deleteArticle(@PathVariable("id") Long id){
		Response responseModel = new Response();
		try {
			articleService.deleteArticle(id);
			responseModel.setCode("0000");
			responseModel.setMessage("YOU HAVE BEEN DELETED THE ARTICLE SUCCESSFULLY.");
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return responseModel;
	}
	
}
