import org.junit.Test;

import java.util.Scanner;

/**
 * Created by 123 on 2017/11/12.
 */

public class Demo {

    public static void main(String[] args) {
        //print();
        //numToString();
     /*   String a = convert(1004);
        System.out.println(a);*/
        Thread t1 = new Thread("t1");
        t1.run();
        Thread t2 = new Thread("t2");
        t2.run();
        Thread t3 = new Thread("t3");
        t3.run();
        Thread t4 = new Thread("t4");
        t4.run();    }

    /**
     * 每十秒打印helloword
     */
    public static void print() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("hello word!!!");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Test
    public void numToString() {

        StringBuffer sb = new StringBuffer();
        String m = "1234";


        for (int i=0;i<m.length();i++){
            System.out.println(m.charAt(i));
            if (m.length() == i) {   //长度大于
                switch (m.charAt(i)) {
                    case '1':
                        sb.append("一千");
                        break;

                    case '2':
                        sb.append("俩百");
                        break;
                    case '3':
                        sb.append("");
                        break;
                    case '4':
                        sb.append("");
                        break;

                }
            }
        }



    }

    private static final char[] data = {'零','壹','贰','叄','肆','伍','陆','柒','捌','玖'};
    private static final char[] units = {'元','拾','佰','仟','万','拾','佰','仟','亿'};

    public static String convert(int money){
        StringBuffer sbf = new StringBuffer();
        int uint = 0;
        while(money != 0){
            sbf.insert(0,units[uint++]);
            sbf.insert(0,data[money%10]);
            money = money/10;
        }
        //去零
        return sbf.toString().replaceAll("零[拾佰仟]","零").replaceAll("零+万","万").replaceAll("零+元","元").replaceAll("零+","零");

    }


    Scanner scanner = new Scanner(System.in);

    @Test
        public void caseTo() {
            String a = Long.toHexString(1212);
            System.out.println(a);
        }


    public  static void h() {

    }
}
