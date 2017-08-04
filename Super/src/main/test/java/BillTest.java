import cn.ql.dao.IBillDAO;
import cn.ql.model.Page;
import cn.ql.model.smbms_bill;
import cn.ql.model.smbms_provider;
import cn.ql.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by 123 on 2017/07/14.
 */
public class BillTest {
    SqlSession sqlSession;
    IBillDAO dao;

    @Before    //在单测执行之前，会执行这个方法
    public void before() {
        sqlSession = MybatisUtil.getSqlSession();
        dao = sqlSession.getMapper(IBillDAO.class);
    }

    @After    //无论哪个单测过了之后，就会执行的
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void TestgetBillCount() {
        Map<String, Object> map = new HashMap<String, Object>();
        //map.put("productName", "狗");
        // map.put("isPayment", 1);
        //map.put("proName", "bbbb");
        int billCount = dao.getBillCount(map);
        System.out.println(billCount);
    }


    @Test
    public void TestGetOnePageData() {
        smbms_bill bill = new smbms_bill();
        Page page = new Page();
        page.setPageIndex(0);
        page.setPageSize(2);
        //bill.setProductName("狗");
        //bill.setIsPayment(0);
        smbms_provider provider = new smbms_provider();
        // provider.setProName("bbbb");
        List<smbms_bill> list = dao.GetOneBillPageData(provider, bill, page);
        System.out.println(list);
        for (smbms_bill item : list) {
            System.out.println(item.getProductName());
            System.out.println(item.getProvider().getProName());
        }
        System.out.println(list.size());

    }
}
