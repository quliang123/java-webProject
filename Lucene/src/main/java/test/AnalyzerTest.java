package test;


import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;

import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.junit.Test;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;
import org.wltea.analyzer.lucene.IKAnalyzer;


import java.io.IOException;
import java.io.StringReader;

/**
 * Created by Happy on 2017-12-01.
 */
public class AnalyzerTest {
    @Test
    //分词器
    public void test() throws Exception {
        //String word="a good person,Happy Every Day";
        //String word="我为何不哭，因为我仅存的，就只有坚强了";
        String word="中华人民共和国KWWL  DRGYBN，北大老鸟，我们是";
        //Analyzer analyzer = new StandardAnalyzer();//一元分词

       // Analyzer analyzer=new CJKAnalyzer();  //二元分词
       // Analyzer analyzer=new SmartChineseAnalyzer();  //智能中文分词
        //IK分词
        Analyzer analyzer=new IKAnalyzer(true);
        testAnalyzer(analyzer,word);
    }
    //使用指定的分词器对指定的文本进行分词
    public  void testAnalyzer(Analyzer analyzer, String text) throws Exception {
        System.out.println("分词器：" + analyzer.getClass());
        StringReader reader= new StringReader(text);
        TokenStream tokenStream = analyzer.tokenStream("content",reader);
        tokenStream.reset();
        CharTermAttribute cta =tokenStream.addAttribute(CharTermAttribute.class);
        while (tokenStream.incrementToken()) {
            System.out.println(cta);
        }
        reader.close();
    }
    @Test
    public void tt() throws IOException {
        String text="中华人民，北大青鸟，我们是";
        StringReader sr=new StringReader(text);
        IKSegmenter ik=new IKSegmenter(sr, true);
        Lexeme lex=null;
        while((lex=ik.next())!=null){
            System.out.println(lex.getLexemeText());
        }
    }
}
