package com.catalystsolutions.querybuilder.enums;

public enum Keyword {
    MIN("MIN"), MAX("MAX"), FROM("FROM"), COUNT("COUNT"), LIMIT("LIMIT"), WHERE("WHERE"), OFFSET("OFFSET"),GROUP_BY("GROUP BY"), ORDER_BY("ORDER BY");
    public final String value;

    Keyword(String value) {
        this.value = value;
    }

}
