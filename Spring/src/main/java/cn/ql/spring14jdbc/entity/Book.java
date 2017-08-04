package cn.ql.spring14jdbc.entity;

/**
 * Created by 123 on 2017/08/02.
 */

public class Book {
    private Integer bookId;
    private String booName;
    private Integer bookPrice;

    public Book() {
    }

    public Book(Integer bookId, String booName, Integer bookPrice) {
        this.bookId = bookId;
        this.booName = booName;
        this.bookPrice = bookPrice;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBooName() {
        return booName;
    }

    public void setBooName(String booName) {
        this.booName = booName;
    }

    public Integer getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Integer bookPrice) {
        this.bookPrice = bookPrice;
    }
}
