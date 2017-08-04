package cn.ql.model;

import java.io.Serializable;

/**
 * Created by 123 on 2017/07/21.
 */
public class news implements Serializable {
    private Integer Newsid;
    private String Newstitle;
    private String Newscontent;
    private Integer Clickcount;

    private Integer Tcount = 0;

    public Integer getTcount() {
        return Tcount;
    }

    public void setTcount(Integer tcount) {
        Tcount = tcount;
    }

    public news() {
    }

    public news(Integer newsid, String newstitle, String newscontent, Integer clickcount) {
        Newsid = newsid;
        Newstitle = newstitle;
        Newscontent = newscontent;
        Clickcount = clickcount;
    }

    public Integer getNewsid() {
        return Newsid;
    }

    public void setNewsid(Integer newsid) {
        Newsid = newsid;
    }

    public String getNewstitle() {
        return Newstitle;
    }

    public void setNewstitle(String newstitle) {
        Newstitle = newstitle;
    }

    public String getNewscontent() {
        return Newscontent;
    }

    public void setNewscontent(String newscontent) {
        Newscontent = newscontent;
    }

    public Integer getClickcount() {
        return Clickcount;
    }

    public void setClickcount(Integer clickcount) {
        Clickcount = clickcount;
    }
}
