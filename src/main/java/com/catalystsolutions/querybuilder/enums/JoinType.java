package com.catalystsolutions.querybuilder.enums;

public enum JoinType {
    LEFT_JOIN("LEFT JOIN"),
    INNER_JOIN("INNER JOIN");
    public final String value;

    JoinType(String value){
        this.value = value;
    }
}
