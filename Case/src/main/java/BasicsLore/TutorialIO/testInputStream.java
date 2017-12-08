package BasicsLore.TutorialIO;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

/**
 * Created by 123 on 2017/12/02.
 */

public class testInputStream {


    @Test
    public void lx1() throws IOException {
        File file = new File("D:\\ideaFile\\Y2Projects\\Case\\src\\main\\java\\BasicsLore\\TutorialIO\\aa");
        //创建文件
        //file.createNewFile();

        //创建文件夹
        //file.mkdir();

        boolean flag = file.renameTo(new File("D:\\ideaFile\\Y2Projects\\Case\\src\\main\\java\\BasicsLore\\TutorialIO\\aa.text"));
        System.out.println(flag);
       /*  file.createNewFile();
         file.*/
    }


    /**
     * 用inputStream
     *
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\ideaFile\\Y2Projects\\Case\\src\\main\\java\\BasicsLore\\TutorialIO\\hh.text");
        int a = -1;
        byte[] bytes = new byte[1024];
        while ((a = fis.read(bytes)) != -1) {
            // System.out.println((char) a);
            System.out.println(new String(bytes, 0, a));
        }
    }
}
