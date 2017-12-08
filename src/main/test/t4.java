/**
 * Created by 123 on 2017/11/12.
 */

public class t4 extends Thread {
    static int num = 0;
    private String name;

    public t4(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        t3.num--;
        System.out.println(t3.num);
    }
}
