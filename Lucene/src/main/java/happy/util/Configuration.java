package happy.util;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Happy on 2017-11-30.
 */
public class Configuration {
    //目录
    private static Directory directory;
    //分词器对象
    private static Analyzer analyzer;

    public static Directory getDirectory() {
        return directory;
    }

    public static void setDirectory(Directory directory) {
        Configuration.directory = directory;
    }

    public static Analyzer getAnalyzer() {
        return analyzer;
    }

    public static void setAnalyzer(Analyzer analyzer) {
        Configuration.analyzer = analyzer;
    }

    static {
        //初始化所有配置，应通过配置文件得到配置的值
        final Path path = Paths.get("./article/");
        try {
            directory=FSDirectory.open(path);
            analyzer=new StandardAnalyzer();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
