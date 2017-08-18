package com.erma.model;

import java.io.Serializable;

/**
 * Created by 123 on 2017/08/09.
 */

public class Class_info implements Serializable {
    private Integer cid;
    private String cname;
    private Integer sid;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
