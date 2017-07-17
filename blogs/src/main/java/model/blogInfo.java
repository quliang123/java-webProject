package model;

/**
 * Created by 123 on 2017/07/05.
 */
public class blogInfo {

    private int BlogId;
    private String BlogAuthor;
    private String BlogAddress;
    private int BlogDel;
  private  String BlogSite;

    public String getBlogSite() {
        return BlogSite;
    }

    public void setBlogSite(String blogSite) {
        BlogSite = blogSite;
    }

    public blogInfo() {
    }

    public blogInfo(int blogId, String blogAuthor, String blogAddress, int blogDel) {
        BlogId = blogId;
        BlogAuthor = blogAuthor;
        BlogAddress = blogAddress;
        BlogDel = blogDel;
    }

    public int getBlogId() {

        return BlogId;
    }

    public void setBlogId(int blogId) {
        BlogId = blogId;
    }

    public String getBlogAuthor() {
        return BlogAuthor;
    }

    public void setBlogAuthor(String blogAuthor) {
        BlogAuthor = blogAuthor;
    }

    public String getBlogAddress() {
        return BlogAddress;
    }

    public void setBlogAddress(String blogAddress) {
        BlogAddress = blogAddress;
    }

    public int getBlogDel() {
        return BlogDel;
    }

    public void setBlogDel(int blogDel) {
        BlogDel = blogDel;
    }
}
