package kh.com.kshrd.ams.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import kh.com.kshrd.ams.exceptions.BusinessException;
import kh.com.kshrd.ams.filtering.CategoryFilter;
import kh.com.kshrd.ams.models.Category;
import kh.com.kshrd.ams.models.ResponseModel;
import kh.com.kshrd.ams.services.CategoryService;

@RestController
@RequestMapping(value="/v1/api/categories")
@Api("CATEGORY MANAGEMENT API")
public class RestCategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(method= RequestMethod.GET)
	@ApiOperation("TODO: TO FIND ALL CATEGORY")
	public ResponseModel<List<Category>> findAllCategories(CategoryFilter filter){
		ResponseModel<List<Category>> responseModel = new ResponseModel<List<Category>>();
		try {
			responseModel.setCode("0000");
			responseModel.setMessage("YOU HAVE BEEN FIND ALL CATEGORIES SUCCESSFULLY.");
			responseModel.setData(categoryService.findAllCategories(filter));
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return responseModel;
	}
}
