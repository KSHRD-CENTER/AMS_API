package kh.com.kshrd.ams.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface UploadService {
	
	public String uploadMultipart(CommonsMultipartFile file, HttpServletRequest request);

}
