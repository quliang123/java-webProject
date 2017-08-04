package cn.ql.spring14jdbc.servcie;

import cn.ql.spring14jdbc.entity.Book;

import java.util.List;

/**
 * Created by 123 on 2017/08/02.
 */
public interface IBookService {
    List<Book> findAll();
}
