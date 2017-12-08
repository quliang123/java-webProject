package Case;

import cn.happy.util.Configuration;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Happy on 2017-12-03.
 * 目录优化方案
 */
public class DirectoryTest {
    @Test
    public void test() throws IOException {

        Path path = Paths.get("./article/");
        //文件系统中真实的目录，可存储，但是速度慢
        Directory fsDir= FSDirectory.open(path);

       //在内存中虚拟的目录，速度快，但不可存储
        Directory ramDir=new RAMDirectory();

        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Configuration.getAnalyzer());
        IndexWriter ramIndexWriter=new IndexWriter(ramDir, indexWriterConfig);
        ramIndexWriter.addDocument(new Document());
        ramIndexWriter.close();
    }

    @Test
    public void test2() throws IOException {
        //文件系统中真实的目录，可存储，但是速度慢
        Path path = Paths.get("./article/");
        Directory fsDir= FSDirectory.open(path);
        //在内存中虚拟的目录，速度快，但不可存储
        Directory ramDir=new RAMDirectory();

        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Configuration.getAnalyzer());
        IndexWriter ramIndexWriter=new IndexWriter(ramDir, indexWriterConfig);

        Document document=new Document();

        document.add(new TextField("title","双12", Field.Store.YES));
        document.add(new TextField("id","1", Field.Store.YES));
        ramIndexWriter.addDocument(document);
        ramIndexWriter.close();


        IndexWriterConfig indexWriterConfig2 = new IndexWriterConfig(Configuration.getAnalyzer());
        IndexWriter fsIndexWriter=new IndexWriter(fsDir,indexWriterConfig2);
        fsIndexWriter.addIndexes(ramDir);
        fsIndexWriter.close();
    }
}
