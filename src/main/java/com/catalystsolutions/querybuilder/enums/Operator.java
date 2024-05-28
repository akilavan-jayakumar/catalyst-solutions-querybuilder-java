package com.catalystsolutions.querybuilder.enums;

public enum Operator {
    ON("ON"),
    IN("IN"),
    EQ("="),
    GT(">"),
    LT("<"),
    OR("OR"),
    AND("AND"),
    GTEQ(">="),
    LTEQ("<="),
    LIKE("LIKE");

    public final String value;

    Operator(String value){
        this.value = value;
    }

}
