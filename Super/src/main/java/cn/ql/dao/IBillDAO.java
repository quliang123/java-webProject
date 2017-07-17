package cn.ql.dao;

import cn.ql.model.Page;
import cn.ql.model.smbms_bill;
import cn.ql.model.smbms_provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by 123 on 2017/07/13.
 */
public interface IBillDAO {
    public List<smbms_bill> GetOneBillPageData(@Param("provider") smbms_provider Provider, @Param("bill") smbms_bill bill, @Param("page") Page page);

    public int getBillCount(Map<String, Object> map);

    public int delBill(int id);

    public int modifyBill(smbms_bill bill);

    public int addBill(smbms_bill bill);

    public List<smbms_bill> QueryByCondition(String productName, String proName, Integer isPayment);
}
