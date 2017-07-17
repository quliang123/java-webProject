package model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 123 on 2017/07/12.
 */
public class Category {
    private Integer cid;
    private String cname;
    private  Integer pid;

    public Category(Integer cid, String cname, Integer pid, Set<Category> cates) {
        this.cid = cid;
        this.cname = cname;
        this.pid = pid;
        this.cates = cates;
    }

    public Category() {

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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", pid=" + pid +
                ", cates=" + cates +
                '}';
    }

    public Set<Category> getCates() {
        return cates;
    }

    public void setCates(Set<Category> cates) {
        this.cates = cates;
    }

    //植入自己的一个泛型
    private Set<Category> cates=new HashSet<Category>();

}
