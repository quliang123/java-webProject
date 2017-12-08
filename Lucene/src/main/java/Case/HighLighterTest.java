package Case;

import happy.entity.Article;
import happy.util.AritcleDocumentUtils;
import happy.util.Configuration;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.*;
import org.junit.Test;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by 123 on 2017/12/06.
 * 高亮Demo
 */

public class HighLighterTest {
    @Test
    public void search() throws IOException, ParseException, InvalidTokenOffsetsException {
        String keyWord = "疯狂";

        IndexReader indexReader = DirectoryReader.open(Configuration.getDirectory());

        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        QueryParser queryParser = new MultiFieldQueryParser(new String[]{"title", "content"}, Configuration.getAnalyzer());

        Query query = queryParser.parse(keyWord);

        TopDocs topDocs = indexSearcher.search(query, 100);

        int count = (int) topDocs.totalHits;

        ScoreDoc[] docs = topDocs.scoreDocs;

        Formatter formatter = new SimpleHTMLFormatter("<front color='red'>", "</front>");
        Scorer scorer = new QueryScorer(query, "content");
        Highlighter highlighter = new Highlighter(formatter, scorer);

        Fragmenter fragmenter = new SimpleFragmenter(20);
        highlighter.setTextFragmenter(fragmenter);

        List<Article> list=new ArrayList<Article>();
        for (int i=0;i<docs.length;i++){
            int docid=docs[i].doc;
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
