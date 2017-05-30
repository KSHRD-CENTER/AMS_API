package kh.com.kshrd.ams.configurations;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

//TODO: ADD THE CorsFilter 1 For Control the Response
// COPY FROM http://websystique.com/springmvc/spring-mvc-4-restful-web-services-crud-example-resttemplate/
// THAT ALL SORRY FOR LONG TIME HEHE
// it's okay thanks so much. but is there any problem when it hosting?
//cuz I test with localhost recently it works
// but  when I access to ip 120 then it error.
// YES TELL KOKPHENG HELP TO UPLOAD THAT CODE TO SERVER
// yes I will, if have any problems will ask you again ^^ thanks you so much
// I ADD YOU TO THAT REPOSITORY ALREADY 
// i seee Thanks ^^ BYE BYE yes good night YES
public class CorsFilter implements Filter {
	 

  
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        System.out.println("Filtering on...........................................................");
//        HttpServletResponse response = (HttpServletResponse) res;
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, Authorization");
//        chain.doFilter(req, res);
    	
    	   HttpServletResponse response = (HttpServletResponse) res;
           response.setHeader("Access-Control-Allow-Origin", "*");
           response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
           response.setHeader("Access-Control-Max-Age", "3600");
           response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
           chain.doFilter(req, res);

    }
 
    public void init(FilterConfig filterConfig) {}
 
    public void destroy() {}
 
}