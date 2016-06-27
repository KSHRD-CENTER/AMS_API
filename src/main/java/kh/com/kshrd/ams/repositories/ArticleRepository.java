package kh.com.kshrd.ams.repositories;

import kh.com.kshrd.ams.filtering.ArticleFilter;
import kh.com.kshrd.ams.models.Article;

public interface ArticleRepository extends BaseRepository<Article, Long, ArticleFilter>{
	
}
