package com.kakayunmu.util.sql;

import com.kakayunmu.util.sql.model.SqlRetModel;
import com.kakayunmu.util.sql.param.ParamQuery;
import com.kakayunmu.util.sql.param.ParamQueryData;
import com.kakayunmu.util.sql.param.WhereData;

import java.util.ArrayList;
import java.util.List;


public class BuilderQuery {

    public BuilderQuery() {

    }

    public BuilderQuery(String placeHolder) {
        this.placeholder = placeHolder;
    }

    private String placeholder = "?";

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }


    public String buildSqlStr(ParamQuery paramQuery) throws Exception {
        return createSql(paramQuery, false).getSqlStr();
    }

    public SqlRetModel buildSql(ParamQuery paramQuery) throws Exception {
        return createSql(paramQuery, true);
    }

    private SqlRetModel createSql(ParamQuery paramQuery, boolean usePlaceholder) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        if (paramQuery == null) {
            return null;
        }
        ParamQueryData data = paramQuery.getData();
        if (data.getSelect() == null || "".equals(data.getSelect())) {
            stringBuffer.append("SELECT * ");
        } else {
            stringBuffer.append("SELECT ");
            stringBuffer.append(data.getSelect().trim());
        }

        if (data.getFrom() == null || "".equals(data.getFrom())) {
            throw new Exception("缺少 from 参数");
        }

        stringBuffer.append(" FROM ");
        stringBuffer.append(data.getFrom().trim());
        stringBuffer.append(" ");
        SqlRetModel sqlRetModel = createWhereSql(data, usePlaceholder);
        stringBuffer.append(sqlRetModel.getSqlStr());

        if (data.getOrderBy() != null && !"".equals(data.getOrderBy())) {
            stringBuffer.append(" ORDER BY ");
            stringBuffer.append(data.getOrderBy());
        }
        if (data.getGroupBy() != null && !"".equals(data.getGroupBy())) {
            stringBuffer.append(" GROUP BY ");
            stringBuffer.append(data.getGroupBy());
        }
        if (data.getHaving() != null && !"".equals(data.getHaving())) {
            stringBuffer.append(" HAVING ");
            stringBuffer.append(data.getHaving());
        }
        sqlRetModel.setCurrentPage(data.getPagingCurrentPage());
        sqlRetModel.setItemsPerPage(data.getPagingItemsPerPage());
        sqlRetModel.setSqlStr(stringBuffer.toString());
        return sqlRetModel;
    }

    private SqlRetModel createWhereSql(ParamQueryData data, boolean usePlaceholder) {

        List<String> parameterList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        if (data.getWhere() != null && data.getWhere().size() > 0) {
            stringBuffer.append(" WHERE");
            boolean isNotFirst = false;

            for (WhereData whereData : data.getWhere()) {
                if (isNotFirst) {
                    stringBuffer.append(" ");
                    stringBuffer.append(whereData.getAndOr());
                }
                isNotFirst = true;
                stringBuffer.append(" ");
                if (null != whereData.getWhereSql() && !"".equals(whereData.getWhereSql())) {
                    stringBuffer.append(whereData.getWhereSql().trim());
                } else {
                    parameterList.add(whereData.getValue().toString());
                    stringBuffer.append(createWhere(whereData, usePlaceholder));
                }
            }
        }
        SqlRetModel sqlRetModel = new SqlRetModel();
        sqlRetModel.setParameters(parameterList.toArray(new String[0]));
        sqlRetModel.setSqlStr(stringBuffer.toString());
        return sqlRetModel;
    }

    private String createWhere(WhereData whereData, boolean usePlaceholder) {
        String formatStr = "";
        switch (whereData.getCompare()) {
            case EQUAL:
                formatStr = "{key}={value}";
                break;
            case NOT_EQUAL:
                formatStr = "{key}<>{value}";
                break;
            case GREATER:
                formatStr = "{key}>{value}";
                break;
            case GREATER_EQUAL:
                formatStr = "{key}>={value}";
                break;
            case DATETIME_GREATER_EQUAL:
                formatStr = "DATEDIFF(DAY,{value},{key})>0";
                break;
            case LESS:
                formatStr = "{key}<{value}";
                break;
            case LESS_EQUAL:
                formatStr = "{key}<={value}";
                break;
            case DATETIME_LESS_EQUAL:
                formatStr = "DATEDIFF(DAY,{value},{key})<0";
                break;
            case LIKE:
                formatStr = "{key} LIKE {value}";
                break;
            default:
                formatStr = "{key}={value}";
                break;
        }
        if (!usePlaceholder) {
            return formatStr.replaceAll("\\{key\\}", whereData.getColumn()).replaceAll("\\{value\\}", "'" + whereData.getValue() + "'");
        } else {
            return formatStr.replaceAll("\\{key\\}", whereData.getColumn()).replaceAll("\\{value\\}", placeholder);
        }
    }
}
