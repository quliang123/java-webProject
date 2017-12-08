package Case;

import entity.Article;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 123 on 2017/12/03.
 *
 * @author 123
 */

public class Case1 {
    /**
     * 创建索引
     *
     * @throws IOException
     */
    @Test
    public void createIndex() throws IOException {
        //准备实体,模拟DB
        Article article = new Article();
        article.setId(1);
        article.setTitle("双十二");
        article.setContent("双十二就要疯狂购");

        //准备当前目录的路径
        Path path = Paths.get("./article/");

        //准备分词器
        Analyzer analyzer = new StandardAnalyzer();

        //准备写入器配置
        IndexWriterConfig config = new IndexWriterConfig(analyzer);

        //进行配置是创建还是追加
        config.setOpenMode(IndexWriterConfig.OpenMode.CREATE);

        //索引的存储路径
        Directory dir = FSDirectory.open(path);

        //准备文档对象
        Document doc = new Document();

        //往文档对象中添加数据
        doc.add(new TextField("id", article.getId().toString(), Field.Store.YES));
        doc.add(new TextField("title", article.getTitle(), Field.Store.YES));
        doc.add(new TextField("content", article.getContent(), Field.Store.YES));

        //索引写入器    准备索引存储路径      索引写入器配置文件
        IndexWriter indexWriter = new IndexWriter(dir, config);

        //索引写入器添加文档对象
        indexWriter.addDocument(doc);

        //关闭索引写入器
        indexWriter.close();

    }

    @Test
    public void searhcKeyWord() throws IOException, ParseException {
        //1.1   索引库位置
        Path path = Paths.get("./article/");
        // 1.2  读取索引库文件变成directory对象
        Directory dir = FSDirectory.open(path);
        //1.3  标准分词器
        Analyzer analyzer = new StandardAnalyzer();

        //1.4  关键字
        String keyWord = "双十二";

        //1.5  创建indexSearcher  检索索引的对象,里面要传递上面写入的内存目录对象directory
        IndexReader indexReader = DirectoryReader.open(dir);

        //1.6  索引搜索
        IndexSearcher searcher = new IndexSearcher(indexReader);

        //1.7  针对一个字段进行查询   分词器
        QueryParser queryParser = new QueryParser("title", analyzer);

        //1.8   query 抽象类
        //1.8   query 抽象类
        Query query = queryParser.parse(keyWord);

        TopDocs topDocs = searcher.search(query, 100);

        int count = (int) topDocs.totalHits;

        System.out.println("总数量" + count);

        ScoreDoc[] docs = topDocs.scoreDocs;

        List<Article> list = new LinkedList<Article>();

        for (ScoreDoc item : docs) {
            int docId = item.doc;
            Document doc = searcher.doc(docId);

            Article article = new Article();
            article.setContent(doc.get("id"));
            article.setContent(doc.get("title"));
            article.setContent(doc.get("content"));
            list.add(article);
        }

        for (Article item : list) {
            System.out.println(item.getContent());
        }

    }


    public static void main(String[] args) {
        search("十二");
    }

    public static void search(String keyWord) {
        DirectoryReader directoryReader = null;
        try {
            // 1、创建Directory
            Directory directory = FSDirectory.open(FileSystems.getDefault().getPath("./article"));
            // 2、创建IndexReader
            directoryReader = DirectoryReader.open(directory);
            // 3、根据IndexReader创建IndexSearch
            IndexSearcher indexSearcher = new IndexSearcher(directoryReader);

            // 4、创建搜索的Query
            Analyzer analyzer = new StandardAnalyzer();
            // 创建parser来确定要搜索文件的内容，第一个参数为搜索的域
            QueryParser queryParser = new QueryParser("content", analyzer);
            // 创建Query表示搜索域为content包含UIMA的文档
            Query query = queryParser.parse(keyWord);

            // 5、根据searcher搜索并且返回TopDocs
            TopDocs topDocs = indexSearcher.search(query, 10);
            System.out.println("查找到的文档总共有：" + topDocs.totalHits);

            // 6、根据TopDocs获取ScoreDoc对象
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            for (ScoreDoc scoreDoc : scoreDocs) {

                // 7、根据searcher和ScoreDoc对象获取具体的Document对象
                Document document = indexSearcher.doc(scoreDoc.doc);

                // 8、根据Document对象获取需要的值
                System.out.println(document.get("filename") + " " + document.get("filepath"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (directoryReader != null) {
                    directoryReader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
