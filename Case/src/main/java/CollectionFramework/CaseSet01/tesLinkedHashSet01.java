package CollectionFramework.CaseSet01;

import java.util.*;

/**
 * Created by 123 on 2017/12/07
 *
 * @author 123
 *         LinkedHashSet在迭代访问集合中全部元素时,性能比HashSet好,
 *         但是插入时性能稍微逊色于HashSet
 *
 */

public class tesLinkedHashSet01 {
    public static void main(String[] args) {
        Random r = new Random();

        HashSet<Dog> hashSet = new HashSet<Dog>();
        TreeSet<Dog> treeSet = new TreeSet<Dog>();
        LinkedHashSet<Dog> linkedHashSet = new LinkedHashSet<Dog>();

        long startTime = System.nanoTime();

        for (int i = 0; i < 10000; i++) {
            int x = r.nextInt(1000 - 10) + 10;
            hashSet.add(new Dog(x));
        }

        //end Time
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("HashSet:" + duration);

         startTime = System.nanoTime();

        for (int i = 0; i < 10000; i++) {
            int x = r.nextInt(1000 - 10) + 10;
            treeSet.add(new Dog(x));
        }

        //end Time
         endTime = System.nanoTime();
         duration = endTime - startTime;
        System.out.println("treeSet:" + duration);

        startTime = System.nanoTime();

        for (int i = 0; i < 10000; i++) {
            int x = r.nextInt(1000 - 10) + 10;
            linkedHashSet.add(new Dog(x));
        }

        //end Time
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("linkedHashSet:" + duration);

    }
}
