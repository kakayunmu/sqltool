package com.kakayunmu.util.sql.param;

import java.util.ArrayList;
import java.util.List;

public class ParamQueryData {
    private int pagingCurrentPage;
    private int pagingItemsPerPage;

    private  String having;
    private  String groupBy;
    private  String orderBy;
    private  String from;
    private  String select;

    private List<WhereData> where = new ArrayList<WhereData>();

    public int getPagingCurrentPage() {
        return pagingCurrentPage;
    }

    public int getPagingItemsPerPage() {
        return pagingItemsPerPage;
    }

    public String getHaving() {
        return having;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public String getFrom() {
        return from;
    }

    public String getSelect() {
        return select;
    }

    public List<WhereData> getWhere() {
        return where;
    }

    public void setPagingCurrentPage(int pagingCurrentPage) {
        this.pagingCurrentPage = pagingCurrentPage;
    }

    public void setPagingItemsPerPage(int pagingItemsPerPage) {
        this.pagingItemsPerPage = pagingItemsPerPage;
    }

    public void setHaving(String having) {
        this.having = having;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public void setWhere(List<WhereData> where) {
        this.where = where;
    }
}
