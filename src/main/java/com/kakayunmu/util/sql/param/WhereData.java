package com.kakayunmu.util.sql.param;

public class WhereData {
    private  String andOr;
    private  String column;
    private  Object value;
    private  String whereGroup;
    private  String whereSql;
    private CompareEnum compare;

    public  WhereData(){

    }

    public  WhereData(String andOr,String column,Object value,String whereGroup,CompareEnum compare){
        this.andOr=andOr;
        this.column=column;
        this.value=value;
        this.whereGroup=whereGroup;
        this.compare=compare;
    }

    public  WhereData(String andOr,String whereSql){
        this.andOr=andOr;
        this.whereSql=whereSql;
    }

    public String getAndOr() {
        return andOr;
    }

    public String getColumn() {
        return column;
    }

    public Object getValue() {
        return value;
    }

    public String getWhereGroup() {
        return whereGroup;
    }

    public void setAndOr(String andOr) {
        this.andOr = andOr;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setWhereGroup(String whereGroup) {
        this.whereGroup = whereGroup;
    }

    public String getWhereSql() {
        return whereSql;
    }

    public void setWhereSql(String whereSql) {
        this.whereSql = whereSql;
    }

    public CompareEnum getCompare() {
        return compare;
    }

    public void setCompare(CompareEnum compare) {
        this.compare = compare;
    }
}
