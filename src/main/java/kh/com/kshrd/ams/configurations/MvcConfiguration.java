package kh.com.kshrd.ams.configurations;

import java.util.List;
import java.util.Locale;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.resource.GzipResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = { "kh.com.kshrd.ams.restcontrollers" })
@PropertySource("classpath:application.properties")
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	private Environment environment;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").resourceChain(true)
				.addResolver(new GzipResourceResolver());
		registry.addResourceHandler("/images/**")
				.addResourceLocations("file:/opt/resources/images/", "file:/opt/resources/image-thumbnails/")
				.resourceChain(true).addResolver(new GzipResourceResolver());
		registry.addResourceHandler("/image-thumbnails/**")
				.addResourceLocations("file:/opt/resources/image-thumbnails/").resourceChain(true)
				.addResolver(new GzipResourceResolver());

		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("swagger/index");
		registry.addViewController("/swagger").setViewName("swagger/index");
	}

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public DataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setJdbcUrl(environment.getProperty("AMSAPI.datasource.url"));
		dataSource.setDriverClassName(environment.getProperty("AMSAPI.datasource.driver"));
		dataSource.setUsername(environment.getProperty("AMSAPI.datasource.username"));
		dataSource.setPassword(environment.getProperty("AMSAPI.datasource.password"));
		dataSource.setMaximumPoolSize(200);
		dataSource.setMaxLifetime(200);
		dataSource.setIdleTimeout(300);
		dataSource.setMinimumIdle(3);
		dataSource.setPoolName("SpringMVCHikariCP");
		return dataSource;
	}

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}

	@Bean
	public PlatformTransactionManager dataSourceTransactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS", "PATCH")
				.allowedOrigins("*");
	}

	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(2097152000);
		return multipartResolver;
	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(mappingJackson2HttpMessageConverter());
	}

	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(
				new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false));
		return converter;
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:/i18n/messages/message", "classpath:/i18n/errors/error",
				"classpath:/i18n/validations/validation");
		messageSource.setCacheSeconds(0);
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setDefaultLocale(new Locale("en"));
		resolver.setCookieName("AMSAPILocale");
		resolver.setCookieMaxAge(4800);
		return resolver;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("language");
		return lci;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

	@Bean
	public MessageSourceAccessor messageSourceAccessor() {
		return new MessageSourceAccessor(messageSource());
	}

	/*
	 * @Bean public Base64EncodedImageHttpMessageConverter getImageConverter() {
	 * Base64EncodedImageHttpMessageConverter converter = new
	 * Base64EncodedImageHttpMessageConverter(); return converter; }
	 */

}