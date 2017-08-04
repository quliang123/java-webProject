package cn.ql.dao;

import cn.ql.model.talk;

import java.util.List;

/**
 * Created by 123 on 2017/07/21.
 */
public interface ItalkDAO {
    public List<talk> getTalkList(Integer nid);

    public int addTalk(talk talk);
}
