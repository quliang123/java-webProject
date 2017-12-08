/**
 * Created by 123 on 2017/11/12.
 */

public class t2 extends Thread {
    private String name;

    public t2(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        t1.num++;
        System.out.println(t1.num);
    }
}
