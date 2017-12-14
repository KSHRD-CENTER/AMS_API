package kh.com.kshrd.ams.restcontrollers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import kh.com.kshrd.ams.models.ResponseRecord;
import kh.com.kshrd.ams.services.UploadService;

@RestController
@Api("FILE MANAGEMENT API")
@RequestMapping(value="/v1/api/uploadfile")
public class RestFileUploadController {
		
	@Autowired
	private UploadService uploadService;
	
	
	@ApiOperation("TODO: TO UPLOAD FILE")
	@RequestMapping(value="/single", method = RequestMethod.POST)
	public ResponseRecord<String> signup(
			@RequestParam("FILE") CommonsMultipartFile file, 
			HttpServletRequest request){
		ResponseRecord<String> responseModel = new ResponseRecord<String>();
		try {
			
			String url = uploadService.uploadMultipart(file, request);
			if(url!=null){
				responseModel.setCode("0000");
				responseModel.setMessage("YOU HAVE BEEN UPLOAD FILE SUCCESSFULLY.");
				responseModel.setData(url);
			}else{
				responseModel.setCode("9999");
				responseModel.setMessage("YOU HAVE UPLOAD FILE FAILURE.");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return responseModel;
	}
}
