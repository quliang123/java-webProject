package Utils.POIUtils;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */
public class POITest {
    @Test
    public void test1() throws Exception {
        Book book=new Book();
        book.setBookprice(99);
        book.setBookname("gg");
        book.setBookid(5);
        Book book1=new Book();
        book1.setBookprice(99);
        book1.setBookname("gg");
        book1.setBookid(5);
        List<Book> list=new ArrayList<Book>();
        list.add(book);
        list.add(book1);
        CreationExecl.creatExecl(list);
    }
    @Test
    public void test2() throws Exception{
        List<Book> list = CreationExecl.readExcel("E:\\wps文件\\ExeclFile\\Book.xls", Book.class);
        for (Book item:list) {
            System.out.println(item.getBookid());
            System.out.println(item.getBookname());
            System.out.println(item.getBookprice());
        }

    }
    @Test
    public void test3() throws Exception{
        Field[] fields = Book.class.getDeclaredFields();
        for (Field item:fields) {
            item.setAccessible(true);
            ColumnName columnName = item.getAnnotation(ColumnName.class);
            String name = columnName.getName();
            System.out.println(name);

        }

    }
}
