package Case;

import happy.util.LuceneUtil;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.LogByteSizeMergePolicy;
import org.apache.lucene.index.LogDocMergePolicy;
import org.apache.lucene.index.LogMergePolicy;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Happy on 2017-12-03.
 */
public class TestOptimize {
    @Test
    //多个索引库文件合并成大文件
    public void test() throws IOException {
       LuceneUtil.getIndexWriter().forceMerge(1);
    }
}
