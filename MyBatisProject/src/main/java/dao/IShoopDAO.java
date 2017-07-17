package dao;

import model.Category;

import java.util.List;

/**
 * Created by 123 on 2017/07/12.
 */
public interface IShoopDAO {
    public List<Category> getChilderByPid(Integer pid);
}
