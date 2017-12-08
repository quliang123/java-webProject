package entity;

/**
 * Created by 123 on 2017/12/03.
 * @author 123
 */
public class Article {
    private Integer id;
    private String title;
    private String Content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
