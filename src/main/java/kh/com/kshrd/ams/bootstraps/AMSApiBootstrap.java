package kh.com.kshrd.ams.bootstraps;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import kh.com.kshrd.ams.configurations.MvcConfiguration;
import kh.com.kshrd.ams.configurations.RootContextConfiguration;

public class AMSApiBootstrap extends AbstractAnnotationConfigDispatcherServletInitializer {
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootContextConfiguration.class};
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { MvcConfiguration.class };
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    
}
