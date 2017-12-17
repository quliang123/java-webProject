package happy.util;

import happy.entity.Article;
import org.apache.lucene.document.Document;

import org.apache.lucene.document.TextField;

import java.lang.reflect.Field;

/**
 * Created by Happy on 2017-11-30.
 */
public class ObjectDocumentUtils<T> {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        ObjectDocumentUtils utils = new ObjectDocumentUtils();
         utils.articleToDocument(new Article(1,"222","333"));
    }


    //01.将Article转换成Document
    public Document articleToDocument(Article article) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
       /* Document document = new Document();
        Class clazz = t.getClass();
        Field[] fields= clazz.getDeclaredFields();
        Field.setAccessible(fields, true);
        for (Field items : fields) {
            System.out.println(items.get(t));
            System.out.println(items.getName());
         document.add(new TextField(items.getName(), String.valueOf(items.get(t)) ,org.apache.lucene.document.Field.Store.YES));
        }*/

        Document document=new Document();
        document.add(new TextField("title",article.getTitle(), org.apache.lucene.document.Field.Store.YES));
        document.add(new TextField("id",article.getId().toString(),org.apache.lucene.document.Field.Store.YES));
        document.add(new TextField("content",article.getContent(),org.apache.lucene.document.Field.Store.YES));
        //return document;

        return document;

    }
    //02.把Document转换成Article

    public static Article documentToArticle(Document document) {
        Article article = new Article();
        article.setId(Integer.parseInt(document.get("id")));
        article.setTitle(document.get("title"));
        article.setContent(document.get("content"));
        return article;
    }
}
