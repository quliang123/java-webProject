package CollectionFramework.CaseSet01;

import java.util.Comparator;

/**
 * Created by 123 on 2017/12/07.
 *    HashSet  TreeSet  LinkedHashSet   进行比较
 *
 */
public class Dog implements Comparable<Dog> {
    private int size;
    public Dog(int size) {
        this.size = size;
    }
    @Override
    public int compareTo(Dog o) {
        return size - o.size;
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
}
