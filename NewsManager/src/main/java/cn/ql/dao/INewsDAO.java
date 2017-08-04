package cn.ql.dao;

import cn.ql.model.Page;
import cn.ql.model.news;
import cn.ql.model.talk;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 123 on 2017/07/21.
 */
public interface INewsDAO {
    public int getTalkCount(Integer Newsid);

    public List<news> getOnePageData(@Param("page") Page page);

    public int getCount();

    public boolean updateCount(news news);
}
