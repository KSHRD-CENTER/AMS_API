package kh.com.kshrd.ams.restcontrollers;

import java.util.List;

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

import kh.com.kshrd.ams.filtering.ArticleFilter;
import kh.com.kshrd.ams.forms.ArticleForm;
import kh.com.kshrd.ams.models.Article;
import kh.com.kshrd.ams.models.Category;
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
		ResponseList<Article> responseModel = new ResponseList<Article>();
		try {
			List<Article> list = articleService.findAllArticles(filter, pagination);
			if (list != null) {
				responseModel.setCode("0000");
				responseModel.setMessage("YOU HAVE BEEN FIND ALL ARTICLES SUCCESSFULLY.");
				responseModel.setData(list);
				responseModel.setPagination(pagination);
			} else {
				responseModel.setCode("9999");
				responseModel.setMessage("THE REQUESTED OPERATION FAILED BECAUSE A RESOURCE ASSOCIATED WITH THE REQUEST COULD NOT BE FOUND.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseModel;
	}

	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	@ApiOperation("TODO: TO FIND A ARTICLE BY ID")
	public ResponseRecord<Article> findAllArticles(@PathVariable("id") Long id){
		ResponseRecord<Article> responseModel = new ResponseRecord<Article>();
		try {
			Article article = articleService.findArticleById(id);
			if (article != null) {
				responseModel.setCode("0000");
				responseModel.setMessage("YOU HAVE BEEN FIND A ARTICLE SUCCESSFULLY.");
				responseModel.setData(article);
			} else {
				responseModel.setCode("9999");
				responseModel.setMessage("THE REQUESTED OPERATION FAILED BECAUSE A RESOURCE ASSOCIATED WITH THE REQUEST COULD NOT BE FOUND.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseModel;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation("TODO: TO REGISTER A NEW ARTICLE")
	public ResponseRecord<Article> addNewArticle(@RequestBody ArticleForm.InsertArticleForm form, HttpServletRequest request){
		ResponseRecord<Article> responseModel = new ResponseRecord<Article>();
		try {

			Article article = new Article();
			User user = new User();
			user.setId(form.getAuthor());
			article.setAuthor(user);
			article.setTitle(form.getTitle());
			article.setDescription(form.getDescription());
			//article.setImage(uploadService.uploadMultipart(form.getImage(), request));
			article.setImage(form.getImage());

			Category category = new Category();
			category.setId(form.getCategoryId());

			article.setCategory(category);
			Article result = articleService.addNewArticle(article);


			if (result != null) {
				responseModel.setCode("0000");
				responseModel.setMessage("YOU HAVE BEEN ADD NEW ARTICLE SUCCESSFULLY.");
				responseModel.setData(result);
			} else {
				responseModel.setCode("9999");
				responseModel.setMessage("THE REQUESTED OPERATION FAILED BECAUSE A RESOURCE ASSOCIATED WITH THE REQUEST COULD NOT BE FOUND.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseModel;
	}

	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	@ApiOperation("TODO: TO UPDATE A ARTICLE BY ID")
	public  ResponseRecord<Article> deleteArticle(@PathVariable("id") Long id, @RequestBody ArticleForm.UpdateArticleForm form, HttpServletRequest request ){
		ResponseRecord<Article> responseModel = new  ResponseRecord<Article>();
		try {
			Article article = new Article();
			article.setId(id);
			User user = new User();
			user.setId(form.getAuthor());
			article.setAuthor(user);
			article.setTitle(form.getTitle());
			article.setDescription(form.getDescription());
			article.setImage(form.getImage());

			Category category = new Category();
			category.setId(form.getCategoryId());

			article.setCategory(category);

			Article result = articleService.updateArticle(article);
			if (result != null) {
				responseModel.setCode("0000");
				responseModel.setMessage("YOU HAVE BEEN UPDATED THE ARTICLE SUCCESSFULLY.");
				responseModel.setData(result);
			} else {
				responseModel.setCode("9999");
				responseModel.setMessage("THE REQUESTED OPERATION FAILED BECAUSE A RESOURCE ASSOCIATED WITH THE REQUEST COULD NOT BE FOUND.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseModel;
	}

	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	@ApiOperation("TODO: TO DELETE A ARTICLE BY ID")
	public ResponseRecord<Article> deleteArticle(@PathVariable("id") Long id){
		ResponseRecord<Article> responseModel = new ResponseRecord<Article>();
		try {
			Article article = new Article();
			article = articleService.deleteArticle(id);
			if(article!=null){
				responseModel.setCode("0000");
				responseModel.setMessage("ARTICLE HAVE BEEN DELETE SUCCESSFULLY.");
				responseModel.setData(article);
			}else{
				responseModel.setCode("9999");
				responseModel.setMessage("THE REQUESTED OPERATION FAILED BECAUSE A RESOURCE ASSOCIATED WITH THE REQUEST COULD NOT BE FOUND.");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return responseModel;
	}	
}
