package Case;

import cn.happy.entity.Article;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Happy on 2017-11-29.
 * API 接口和类，用来操作特定组件的一个工具集锦
 */
public class LuceneTest {
    @Test
    //创建索引  数据(单个实体)-------》Document     IndexWriter.addDocument(doc);
    public void createIndex() throws IOException {
        //1.1 构建Article对象  从DB 拎取到内存 一个文章对象
        Article article=new Article();
        article.setId(1); //模拟数据
        article.setTitle("双12");
        article.setContent("双12就要疯狂购");

        //1.2 设置索引库存放的位置: 点代表当前路径
        Path path = Paths.get("./article/");
        //1.3 创建一个标准分词器
        /**
         *  StandardAnalyzer是lucene中内置的“标准分析器”，可以做如下功能:
         对原有句子按照空格进行了分词
         所有的大写字母都可以能转换为小写的字母
         可以去掉一些没有用处的单词，例如"is","the","are"等单词，也删除了所有的标点
         */
        Analyzer analyzer = new IKAnalyzer();

        //1.4  创建IndexWriterConfig实例时，通过IndexWriterConfig来设置其相关配置：入参是分词器对象
        //绑定分词器作为入参
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        //1.5 设置索引库的写入模式为创建
        indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        //1.6 索引的存储路径
        Directory directory= FSDirectory.open(path);
        //1.7 创建Document 文档对象，在lucene中创建的索引可以看成数据库中的一张表，
        //表中也可以有字段,往里面添加内容之后可以根据字段去匹配查询
        //下面创建的doc对象中添加了三个字段，分别为title,id,content,
        Document document=new Document();
          /*
            * 参数说明 public TextField(String name, String value, Store store)
            * name : 字段名称
            * value : 字段的值
             * store :Field.Store.YES:存储字段值
            */
        document.add(new TextField("title",article.getTitle(),Field.Store.YES));
        document.add(new TextField("id",article.getId().toString(), Field.Store.YES));
        document.add(new TextField("content",article.getContent(), Field.Store.YES));
        //1.8  IndexWriter用于更新或创建索引。它不是用来读取索引。
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
        //1.9 将构建好的文档对象写入索引库中
        indexWriter.addDocument(document);
        //1.10
        indexWriter.close();//这里可以提前关闭，因为dictory 写入硬盘之后 与IndexWriter 没有任何关系了

    }
    //搜索  查询 的过程
    @Test
    public void search() throws IOException, ParseException {
        //1.1 索引库的位置
        Path path = Paths.get("./article/");
        //1.2 读取索引库文件变成directory对象
        Directory directory= FSDirectory.open(path);
        //1.3  创建标准分词器
        Analyzer analyzer = new StandardAnalyzer();

        //1.4  搜索条件
        String  word="就业";
        //1.5  创建IndexSearcher 检索索引的对象，里面要传递上面写入的内存目录对象directory
        IndexReader indexReader=DirectoryReader.open(directory);
        //1.6   索引搜索
        IndexSearcher indexSearcher=new IndexSearcher(indexReader);
        //1.7 针对一个字段进行查询。 入参列名 和 分词器
        QueryParser queryParser=new QueryParser("title",analyzer);
        //1.8 类似  Query抽象类
        Query query=queryParser.parse(word);
        // 1.9  去索引目录中查询，返回的是TopDocs对象，里面存放的就是上面放的document文档对象
        TopDocs topDocs = indexSearcher.search(query, 100);
        //1.10 int totalHits -- 命中的查询的总数。
        int count= (int) topDocs.totalHits;//总结果数
        System.out.println(count+"总记录数");
        //1.11 ScoreDoc 里面有我们真正的文档对象
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
       //处理结果
        List<Article> list=new ArrayList<Article>();
        for (int i=0;i<scoreDocs.length;i++){
            ScoreDoc scoreDoc=scoreDocs[i];
            System.out.println("得分"+scoreDoc.score);

            int docid=scoreDoc.doc;
            //1.12  根据内部编号    取出真正的  Document数据
            Document doc=  indexSearcher.doc(docid);
            //把Document转化成Article
            Article article=new Article();
            article.setId(Integer.parseInt(doc.get("id")));
            article.setTitle(doc.get("title"));
            article.setContent(doc.get("content"));
            list.add(article);
        }
        for (Article arti:list){
            System.out.println(arti.getTitle());
            System.out.println(arti.getContent());
        }
    }
}
