package com.kakayunmu.util.sql.param;

public class ParamQuery {

    public ParamQuery() {
        data = new ParamQueryData();
    }

    private ParamQueryData data;

    public ParamQuery select(String sql) {
        data.setSelect(sql);
        return this;
    }

    public ParamQuery from(String sql) {
        data.setFrom(sql);
        return this;
    }

    public ParamQuery andWhere(String column, Object value) {
        andWhere(column, value, CompareEnum.EQUAL);
        return this;
    }

    public ParamQuery andWhere(String column, Object value, CompareEnum compare) {
        data.getWhere().add(new WhereData("AND", column, value, null, compare));
        return this;
    }

    public  ParamQuery orWher(String column,Object value){
        orWhere(column,value,CompareEnum.EQUAL);
        return  this;
    }
    public ParamQuery orWhere(String column, Object value, CompareEnum compare) {
        data.getWhere().add(new WhereData("OR", column, value, null, compare));
        return this;
    }

    public ParamQuery orWhere(String column, Object value, CompareEnum compare, String whereGroup) {
        data.getWhere().add(new WhereData("OR", column, value, whereGroup, compare));
        return this;
    }

    public ParamQuery andWhereSql(String whereStr) {
        data.getWhere().add(new WhereData("AND", whereStr));
        return this;
    }

    public ParamQuery orWhereSql(String whereStr) {
        data.getWhere().add(new WhereData("OR", whereStr));
        return this;
    }

    public ParamQuery clearWhere() {
        data.getWhere().clear();
        return this;
    }

    public ParamQuery groupBy(String sql) {
        data.setGroupBy(sql);
        return this;
    }

    public ParamQuery orderBy(String sql) {
        data.setOrderBy(sql);
        return this;
    }

    public ParamQuery having(String sql) {
        data.setHaving(sql);
        return this;
    }

    public ParamQuery paging(int currentPage, int itemsPerPage) {
        data.setPagingCurrentPage(currentPage);
        data.setPagingItemsPerPage((itemsPerPage));
        return this;
    }

    public ParamQueryData getData() {
        return data;
    }
}
