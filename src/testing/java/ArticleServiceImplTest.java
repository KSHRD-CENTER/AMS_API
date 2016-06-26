import java.util.ArrayList;
import java.util.List;

import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.util.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import kh.com.kshrd.ams.models.Article;
import kh.com.kshrd.ams.repositories.ArticleRepository;
import kh.com.kshrd.ams.services.impl.ArticleServiceImpl;

public class ArticleServiceImplTest {

	@Mock
	private ArticleRepository articleRepository;
	
	@InjectMocks
	private ArticleServiceImpl articleService;
	
	@Spy
	List<Article> articles = new ArrayList<Article>();

	@Captor
	ArgumentCaptor<Article> captor;
	
	@BeforeClass
	public void setup(){
		MockitoAnnotations.initMocks(this);
		articles = getArticles(); 
	}
	
	@Test
	public void test(){
		Assert.isTrue(true);
	}
	
	public List<Article> getArticles(){
		Article article1 = new Article();
		article1.setId(1L);
		article1.setTitle("ENGLISH BOOK A");
		article1.setStatus("1");
		
		Article article2 = new Article();
		article2.setId(2L);
		article2.setTitle("ENGLISH BOOK B");
		article2.setStatus("1");
		
		articles.add(article1);
		articles.add(article2);
		return articles;
	}
	
}
