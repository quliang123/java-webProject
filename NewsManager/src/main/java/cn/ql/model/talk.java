package cn.ql.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 123 on 2017/07/21.
 */
public class talk implements Serializable {
    private Integer Tid;
    private String Content;
    private Date Talktime;
    private Integer Nid;
    private String Time;

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public talk() {
    }

    public talk(Integer tid, String content, Date talktime, Integer nid) {
        Tid = tid;
        Content = content;
        Talktime = talktime;
        Nid = nid;
    }

    public talk(Integer tid) {
        Tid = tid;
    }

    public Integer getTid() {
        return Tid;
    }

    public void setTid(Integer tid) {
        Tid = tid;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Date getTalktime() {
        return Talktime;
    }

    public void setTalktime(Date talktime) {
        Talktime = talktime;
    }

    public Integer getNid() {
        return Nid;
    }

    public void setNid(Integer nid) {
        Nid = nid;
    }
}
