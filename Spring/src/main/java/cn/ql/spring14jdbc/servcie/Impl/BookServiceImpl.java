package cn.ql.spring14jdbc.servcie.Impl;

import cn.ql.spring14jdbc.dao.IBookDAO;
import cn.ql.spring14jdbc.entity.Book;
import cn.ql.spring14jdbc.servcie.IBookService;

import java.util.List;

/**
 * Created by 123 on 2017/08/02.
 */

public class BookServiceImpl implements IBookService {
    //植入BookDAO
    private IBookDAO dao;

    public IBookDAO getDao() {
        return dao;
    }

    public void setDao(IBookDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Book> findAll() {
        return dao.FindAll();
    }
}
