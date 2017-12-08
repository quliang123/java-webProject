package Utils.POIUtils;


public class Book {
    @ColumnName(getName = "序号")
    private Integer bookid;
    @ColumnName(getName = "姓名")
    private String bookname;
    @ColumnName(getName = "价格")
    private Integer bookprice;

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Integer getBookprice() {
        return bookprice;
    }

    public void setBookprice(Integer bookprice) {
        this.bookprice = bookprice;
    }
}