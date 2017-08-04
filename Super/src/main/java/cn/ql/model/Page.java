package cn.ql.model;

import java.util.List;

public class Page {

    //1.��ǰ�ǵڼ�ҳ
    private int PageIndex;

    //2.ÿҳ��¼��
    private int PageSize;

    //3.�ܼ�¼��
    private int Totalrecords;

    private List<smbms_bill> bills;

    private List<smbms_provider> providers;

    public List<smbms_provider> getProviders() {
        return providers;
    }

    public void setProviders(List<smbms_provider> providers) {
        this.providers = providers;
    }

    public List<smbms_bill> getBills() {
        return bills;
    }

    public void setBills(List<smbms_bill> bills) {
        this.bills = bills;
    }

    private int TotlePages;

    public int getTotlePages() {
        return TotlePages;
    }

    public void setTotlePages(int totlePages) {
        TotlePages = totlePages;
    }

    public List<smbms_bill> getList() {
        return bills;
    }

    public void setList(List<smbms_bill> list) {
        this.bills = list;
    }

    public Page() {
    }

    private List<smbms_user> users;

    public List<smbms_user> getUsers() {
        return users;
    }

    public void setUsers(List<smbms_user> users) {
        this.users = users;
    }

    public Page(int pageIndex, int pageSize, int totalrecords) {
        PageIndex = pageIndex;
        PageSize = pageSize;
        Totalrecords = totalrecords;
    }

    @Override
    public String toString() {
        return "Page{" +
                "PageIndex=" + PageIndex +
                ", PageSize=" + PageSize +
                ", Totalrecords=" + Totalrecords +
                ", bills=" + bills +
                ", TotlePages=" + TotlePages +
                ", users=" + users +
                '}';
    }

    public int getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(int pageIndex) {
        PageIndex = pageIndex;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public int getTotalrecords() {
        return Totalrecords;
    }

    public void setTotalrecords(int totalrecords) {
        Totalrecords = totalrecords;
    }
}
