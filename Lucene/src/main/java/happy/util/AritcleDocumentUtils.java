package happy.util;

import happy.entity.Article;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;

import javax.print.Doc;

/**
 * Created by Happy on 2017-11-30.
 */
public class AritcleDocumentUtils {
    //01.将Article转换成Document
    public static Document articleToDocument(Article article){
        Document document=new Document();
        document.add(new TextField("title",article.getTitle(), Field.Store.YES));
        document.add(new TextField("id",article.getId().toString(), Field.Store.YES));
        document.add(new TextField("content",article.getContent(), Field.Store.YES));
        return document;
    }
    //02.把Document转换成Article
    public static Article  documentToArticle(Document document){
        Article article=new Article();
        article.setId(Integer.parseInt(document.get("id")));
        article.setTitle(document.get("title"));
        article.setContent(document.get("content"));
        return article;
    }
}
