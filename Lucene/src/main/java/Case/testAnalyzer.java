package Case;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by 123 on 2017/12/06.
 * 分词器
 */

public class testAnalyzer {

    @Test
    public void test() throws IOException {
        //String word="a good person,Happy Every Day";
        //String word="我为何不哭，因为我仅存的，就只有坚强了";
        String word="中华人民共和国KWWL  DRGYBN，北大老鸟，我们是";
        //Analyzer analyzer = new StandardAnalyzer();//一元分词
       // Analyzer analyzer = new CJKAnalyzer();  //二元分词
        Analyzer analyzer = new IKAnalyzer(true);


        testAnalyzer(analyzer,word);

    }



    public void testAnalyzer(Analyzer analyzer, String text) throws IOException {
        System.out.println("分词器:" + analyzer.getClass());
        StringReader reader = new StringReader(text);
        TokenStream tokenStream = analyzer.tokenStream("content", reader);
        tokenStream.reset();
        CharTermAttribute cta = tokenStream.addAttribute(CharTermAttribute.class);

        while (tokenStream.incrementToken()) {
            System.out.println(cta);
        }
        reader.close();

    }
}
