package kh.com.kshrd.ams.bootstraps;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import kh.com.kshrd.ams.configurations.CorsFilter;
import kh.com.kshrd.ams.configurations.MvcConfiguration;
import kh.com.kshrd.ams.configurations.RootContextConfiguration;

public class AMSApiBootstrap extends AbstractAnnotationConfigDispatcherServletInitializer {
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootContextConfiguration.class};
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
    	return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    
//    @Override
//    protected Filter[] getServletFilters() {
//    	// TODO Auto-generated method stub
//    	return new Filter[] { new CorsFilter()};
//    }
}