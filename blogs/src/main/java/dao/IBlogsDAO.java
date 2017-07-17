package dao;

import model.blogInfo;
import model.userinfo;

import java.util.List;

/**
 * Created by 123 on 2017/07/06.
 */
public interface IBlogsDAO {
    public List<blogInfo> GetAllBlogs();

    public int getCount();

    public List<blogInfo> GetOnePageData(int pageIndex, int pageSize);

    public boolean delBlog(int id);

    public blogInfo getBlogInfo(int id);

    public  boolean modifyBlog(blogInfo blog);
}
