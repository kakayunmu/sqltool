package com.kakayunmu.util.sql.param;

public enum CompareEnum {
    EQUAL("等于",0),
    NOT_EQUAL("不等于",1),
    GREATER("大于",2),
    GREATER_EQUAL("大于等于",3),
    DATETIME_GREATER_EQUAL("时间大于等于",4),
    LESS("小于",5),
    LESS_EQUAL("小于等于",6),
    DATETIME_LESS_EQUAL("时间小于等于",7),
    LIKE("Like",8);

    CompareEnum(String dic, int i) {
    }
}