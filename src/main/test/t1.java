import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by 123 on 2017/11/12.
 */

public class t1 extends Thread {

    private String name;

    public t1(String name) {
        this.name = name;
    }

    static int num = 0;
    @Override
    public void run() {
        num++;
        System.out.println(num);
    }
}
