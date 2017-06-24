package com.bdqn.entity;

/**
 * Created by 123 on 2017/06/16.
 */
public class shopclasstypelist {
   private  int cid;
   private  String cname;

    public int getCid() {
        return cid;
    }
    private  int classtypeid;

    public int getClasstypeid() {
        return classtypeid;
    }

    public void setClasstypeid(int classtypeid) {
        this.classtypeid = classtypeid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
