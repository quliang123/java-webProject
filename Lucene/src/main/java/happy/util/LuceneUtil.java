package happy.util;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;

import java.io.IOException;

/**
 * Created by Happy on 2017-12-01.
 */
//LuceneUtil工具类
public class LuceneUtil {
    private static IndexWriter indexWriter;
    private static IndexSearcher indexSearcher;
    static {
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Configuration.getAnalyzer());
        indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);

        try {
            indexWriter=new IndexWriter(Configuration.getDirectory(),indexWriterConfig);
            IndexReader indexReader= DirectoryReader.open(Configuration.getDirectory());
            indexSearcher=new IndexSearcher(indexReader);
            System.out.println("已经初始化");
            //指定在jvm退出前要执行的代码
            Runtime.getRuntime().addShutdownHook(new Thread(){
                @Override
                public void run() {
                    closeIndexWriter();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static IndexWriter getIndexWriter() {
        return indexWriter;
    }
   //关闭indexWriter
    public static void closeIndexWriter(){
        if (indexWriter!=null){
            try {
                indexWriter.close();
                System.out.println("已经关闭indexWriter");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public static IndexSearcher getIndexSearcher() {
        return indexSearcher;
    }
}
