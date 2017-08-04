package cn.ql.spring14jdbc.dao.Impl;

import cn.ql.spring14jdbc.dao.IBookDAO;
import cn.ql.spring14jdbc.entity.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 123 on 2017/08/02.
 */

public class BookDAOImpl extends JdbcDaoSupport implements IBookDAO {
    @Override
    public List<Book> FindAll() {
        String sql="select * from book";
        List<Book> books = this.getJdbcTemplate().query(sql, new RowMapper<Book>() {

            @Override
            public Book mapRow(ResultSet resultSet, int i) throws SQLException {
                Book book = new Book();
                book.setBookId(resultSet.getInt("bookId"));
                book.setBookPrice(resultSet.getInt("bookPrice"));
                book.setBooName(resultSet.getString("bookName"));
                return book;
            }
        });
        return books;
    }
}
