package com.catalystsolutions.querybuilder.enums;

public enum LogicalOperator {

    OR("OR"),
    AND("AND");

    public final String value;

    LogicalOperator(String value){
        this.value = value;
    }

}
