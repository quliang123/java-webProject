package cn.ql.dao;

import cn.ql.model.smbms_provider;

import java.util.List;

/**
 * Created by 123 on 2017/07/18.
 */
public interface IProviderDAO {
    public List<smbms_provider> getAllProvider();

    public String searchNameById(int id);

}
