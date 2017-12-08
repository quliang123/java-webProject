package cn.ql;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 123 on 2017/10/30.
 */


public class test {
    @Test
    public void sum() {
       // List<String> list = new LinkedList<>();
       // list.add("111");
      //  System.out.println(list.remove("111"));
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 3, 4, 5};

        int i=0;
        for (int a1:a) { //5        1
            i++;
            for (int b1 : b) {
                i++;
                if (a1==b1) {
                    System.out.println("b"+b1);

                }
            }
        }
        System.out.println("一共循环"+i);
    }
}
