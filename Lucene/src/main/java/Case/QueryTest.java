package Case;

import happy.entity.Article;
import happy.util.AritcleDocumentUtils;
import happy.util.Configuration;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Happy on 2017-12-04.
 */
public class QueryTest {
    @Test
    //关键词查询
    public void testPrimaryKey() throws ParseException, InvalidTokenOffsetsException, IOException {
        Query query= new TermQuery(new Term("content","疯狂"));
        search(query);
    }

    @Test
    //通配符查询  Struts2  WildCard  *_*
    public void testWildCard() throws ParseException, InvalidTokenOffsetsException, IOException {
        /**
         * ?:1个任意字符
         * *:0或者多个任意字符
         */
        Query query= new WildcardQuery(new Term("content","疯*"));
        search(query);
    }

    @Test
    //查询所有
    public void testAll() throws ParseException, InvalidTokenOffsetsException, IOException {
        Query query= new MatchAllDocsQuery();
        search(query);
    }

    @Test
    //模糊查询
    public void testLike() throws ParseException, InvalidTokenOffsetsException, IOException {
        //第二个参数指定最小相似度，表示有多少写对了就查出来
        Query query= new FuzzyQuery(new Term("title","pring"),2);
        search(query);
    }



    public void search(Query query) throws IOException, ParseException, InvalidTokenOffsetsException {
       /* String  word="content:疯狂";*/
        IndexReader indexReader= DirectoryReader.open(Configuration.getDirectory());
        //1.6   索引搜索
        IndexSearcher indexSearcher=new IndexSearcher(indexReader);
       /* //1.7 针对一个字段进行查询。 入参列名 和 分词器
        QueryParser queryParser=new MultiFieldQueryParser(new String[]{"title","content"},Configuration.getAnalyzer());
        //1.8 类似  Query抽象类
        Query query=queryParser.parse(word);*/
      // Query query= new TermQuery(new Term("content","疯狂"));
        // 1.9  去索引目录中查询，返回的是TopDocs对象，里面存放的就是上面放的document文档对象
        TopDocs topDocs = indexSearcher.search(query,100);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;

        //处理结果
        List<Article> list=new ArrayList<Article>();
        for (int i=0;i<scoreDocs.length;i++){
            ScoreDoc scoreDoc=scoreDocs[i];
            System.out.println("得分"+scoreDoc.score);
            int docid=scoreDocs[i].doc;
            //1.12  根据内部编号    取出真正的  Document数据
            Document doc=  indexSearcher.doc(docid);
            //把Document转化成Article
            Article article= AritcleDocumentUtils.documentToArticle(doc);
            list.add(article);
        }
        for (Article arti:list){
            System.out.println("id===="+arti.getId());
            System.out.println(arti.getTitle());
            System.out.println(arti.getContent());
        }
    }
}
