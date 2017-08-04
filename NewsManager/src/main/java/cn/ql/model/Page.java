package cn.ql.model;

import java.util.List;

public class Page {

    //1.��ǰ�ǵڼ�ҳ
    private int PageIndex;

    //2.ÿҳ��¼��
    private int PageSize;

    //3.�ܼ�¼��
    private int Totalrecords;


    public List<news> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<news> newsList) {
        this.newsList = newsList;
    }

    private List<news> newsList;


    private int TotlePages;

    public int getTotlePages() {
        return TotlePages;
    }

    public void setTotlePages(int totlePages) {
        TotlePages = totlePages;
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
