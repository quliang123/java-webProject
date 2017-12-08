package day02;
import happy.entity.Article;
import happy.util.AritcleDocumentUtils;
import happy.util.Configuration;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.search.highlight.Scorer;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Happy on 2017-12-04.
 */
public class HighLighterTest {
    @Test
    public void search() throws IOException, ParseException, InvalidTokenOffsetsException {
        String  word="疯狂";
        IndexReader indexReader= DirectoryReader.open(Configuration.getDirectory());
        //1.6   索引搜索
        IndexSearcher indexSearcher=new IndexSearcher(indexReader);
        //1.7 针对一个字段进行查询。 入参列名 和 分词器
        QueryParser queryParser=new MultiFieldQueryParser(new String[]{"title","content"},Configuration.getAnalyzer());
        //1.8 类似  Query抽象类
        Query query=queryParser.parse(word);
        // 1.9  去索引目录中查询，返回的是TopDocs对象，里面存放的就是上面放的document文档对象
        TopDocs topDocs = indexSearcher.search(query, 100);
        //1.10 int totalHits -- 命中的查询的总数。
        int count= (int) topDocs.totalHits;//总结果数
        System.out.println(count+"总记录数");
        //1.11 ScoreDoc 里面有我们真正的文档对象
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;

        /**
         * 分割线==================================================高亮思路一
         */
        //一、创建并配置高亮器
        //指定摘要的大小
        //创建高亮器
        Formatter formatter=new SimpleHTMLFormatter("<font color='red'>","</font>");
        Scorer scorer=new QueryScorer(query,"content");
        Highlighter highlighter=new Highlighter(formatter,scorer);
        //摘要
        Fragmenter fragmenter=new SimpleFragmenter(20);
        highlighter.setTextFragmenter(fragmenter);

        //处理结果
        List<Article> list=new ArrayList<Article>();
        for (int i=0;i<scoreDocs.length;i++){
            int docid=scoreDocs[i].doc;
            //1.12  根据内部编号    取出真正的  Document数据
            Document doc=  indexSearcher.doc(docid);


            /**
             *
             *分割线二============================================
             *
             *
             */
            //二：做高亮操作  如果高亮字段中没有关键词，返回null
            String text=highlighter.getBestFragment(Configuration.getAnalyzer(),"content",doc.get("content"));
            ((Field) doc.getField("content")).setStringValue(text);
            //把Document转化成Article
            Article article= AritcleDocumentUtils.documentToArticle(doc);
            list.add(article);
        }
        for (Article arti:list){
            System.out.println(arti.getTitle());
            System.out.println(arti.getContent());
        }
    }
}
