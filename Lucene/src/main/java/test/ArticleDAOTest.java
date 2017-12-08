package test;


import happy.dao.ArticleDAO;
import happy.entity.Article;
import happy.entity.SearchResult;
import org.apache.lucene.queryparser.classic.ParseException;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Happy on 2017-12-03.
 */
public class ArticleDAOTest {
    ArticleDAO articleDAO= new ArticleDAO();

    public ArticleDAOTest() throws IOException {
    }

    @Test
    public void testSave(){
        Article article=new Article();
        article.setId(1); //模拟数据
        article.setTitle("双12");
        article.setContent("双12就要疯狂购");
        //创建索引  Lucene上下文  帮我去保存的
        articleDAO.save(article);
    }

    @Test
    public void testMultiSave(){
        for (int i=1;i<=25;i++){
            Article article=new Article();
            article.setId(i); //模拟数据
            article.setTitle("双12======"+i);
            article.setContent("双12就要疯狂购====="+i);
            //创建索引
            articleDAO.save(article);
        }
    }

    //修改
    @Test
    public void testUpdate(){

            Article article=new Article();
            article.setId(1); //模拟数据
            article.setTitle("双12===我是更新后的数据");
            article.setContent("双12就要疯狂购");
            //创建索引
            articleDAO.update(article);

    }

    @Test
    public void testSearch() throws IOException, ParseException {
        String word="双12";
        SearchResult<Article> sr=articleDAO.search(word,20,10);
        System.out.println("总结果数"+sr.getCount());
        for (Article ar:sr.getList()) {
            System.out.println("title==="+ar.getTitle());
        }
    }
}
