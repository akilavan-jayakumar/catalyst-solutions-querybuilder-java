package com.catalystsolutions.querybuilder.utils;

public class QueryUtil {

    public static String toQueryString(String value) {
        return String.format("'%s'", value.replaceAll("'", "''"));
    }
}
