package kh.com.kshrd.ams.restcontrollers;

import java.io.IOException;
import java.sql.SQLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kh.com.kshrd.ams.models.Article;
import kh.com.kshrd.ams.models.Category;
import kh.com.kshrd.ams.models.Response;
import kh.com.kshrd.ams.models.User;
import kh.com.kshrd.ams.repositories.ArticleRepository;

@RestController
@RequestMapping("/api/v1/scrap")
public class Scrap {
	
	@Autowired
	ArticleRepository repo;
	
	@RequestMapping(method = RequestMethod.POST)
	public Response save(@RequestParam("url") String url, @RequestParam("cid") Long cid) throws IOException, SQLException{
		
		String technologyUrl = url;
		Document doc = Jsoup.connect(technologyUrl).get();
		Elements elements = doc.select("div.article");
		for(Element e: elements){
			String title = e.select("h4.title a").text();
			String image = e.select("img").attr("src");
			String description = e.select("p.text").text();
			Article article = new Article();
			article.setTitle(title);
			article.setImage(image);
			article.setDescription(description);
			Category c = new Category();
			c.setId(cid);
			User author =  new User();
			article.setAuthor(author);
			article.setCategory(c);
			repo.save(article);
		}
		return null;
	}
	
}
