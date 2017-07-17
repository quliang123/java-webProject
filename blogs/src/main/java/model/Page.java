package model;

import java.util.List;

public class Page {
		
		//1.��ǰ�ǵڼ�ҳ
		  private int PageIndex;
		
		//2.ÿҳ��¼��
		  private int PageSize;
		  
		//3.�ܼ�¼��
		  private int Totalrecords;

		  private List<blogInfo> list;

		  private  int TotlePages;

    public int getTotlePages() {
        return TotlePages;
    }

    public void setTotlePages(int totlePages) {
        TotlePages = totlePages;
    }

    public List<blogInfo> getList() {
        return list;
    }

    public void setList(List<blogInfo> list) {
        this.list = list;
    }

    public Page() {
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
