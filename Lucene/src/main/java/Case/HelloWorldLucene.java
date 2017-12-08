package Case;

import org.apache.lucene.analysis.shingle.ShingleAnalyzerWrapper;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.RAMDirectory;
import org.springframework.data.redis.core.index.IndexConfiguration;

import java.io.IOException;

/**
 * Created by 123 on 2017/12/03.
 */

public class HelloWorldLucene {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        RAMDirectory directory = new RAMDirectory();

        IndexWriterConfig config = new IndexWriterConfig(new ShingleAnalyzerWrapper());

        IndexWriter writer = new IndexWriter(directory, config);

        Document doc = new Document();

        doc.add(new Field("name", "lin zhengle", TextField.TYPE_STORED));
        doc.add(new Field("address", "中国上海", TextField.TYPE_STORED));
        doc.add(new Field("dosometing", "I am learning lucene ", TextField.TYPE_STORED));
        writer.addDocument(doc);
        writer.close(); // 这里可以提前关闭，因为dictory 写入内存之后 与IndexWriter 没有任何关系了

        // 因为索引放在内存中，所以存放进去之后要立马测试，否则，关闭应用程序之后就检索不到了
        // 创建IndexSearcher 检索索引的对象，里面要传递上面写入的内存目录对象directory
        DirectoryReader ireader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(ireader);
        // 根据搜索关键字 封装一个term组合对象，然后封装成Query查询对象
        // dosometing是上面定义的字段，lucene是检索的关键字
        //TermQuery 是 lucene查询中最基本的一种原子查询，从它的名字Term我们可以看出，它只能针对一个字段进行查询。
        //Term 这个类是搜索的最低单位。它是在索引过程中类似Field。建立搜索单元, SearchType代表要搜索的Filed, searchKey代表关键字
        Query query = new TermQuery(new Term("dosometing", "lucene"));
        // Query query = new TermQuery(new Term("address", "中国上海"));
        // Query query = new TermQuery(new Term("name", "cheng"));

        // TopDocs 指向相匹配的搜索条件的前N个搜索结果。它是指针的简单容器指向它们的搜索结果输出的文档。
        // TopDocs 类的字段：
        // ScoreDoc[] scoreDocs -- 排名靠前的查询。
        //int totalHits -- 命中的查询的总数。

        // 去索引目录中查询，返回的是TopDocs对象，里面存放的就是上面放的document文档对象
        TopDocs rs = searcher.search(query, 100);
        long endTime = System.currentTimeMillis();
        System.out.println("总共花费" + (endTime - startTime) + "毫秒，检索到" + rs.totalHits + "条记录。");
        for (int i = 0; i < rs.scoreDocs.length; i++) {
            // rs.scoreDocs[i].doc 是获取索引中的标志位id, 从0开始记录
            Document firstHit = searcher.doc(rs.scoreDocs[i].doc);
            System.out.println("name:" + firstHit.getField("name").stringValue());
            System.out.println("address:" + firstHit.getField("address").stringValue());
            System.out.println("dosomething:" + firstHit.getField("dosometing").stringValue());
        }

        writer.close();
        directory.close();
        System.out.println("*****************检索结束**********************");
    }
}

