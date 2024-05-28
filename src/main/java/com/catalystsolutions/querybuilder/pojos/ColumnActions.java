package com.catalystsolutions.querybuilder.pojos;

import com.catalystsolutions.querybuilder.enums.Keyword;

import java.text.MessageFormat;

public class ColumnActions {

    public final String max;
    public final String min;
    public final String count;
    public final String value;

    public ColumnActions(String value){
        this.value = value;
        this.min = MessageFormat.format("{0}({1})", Keyword.MIN.value,value);
        this.max = MessageFormat.format("{0}({1})", Keyword.MAX.value,value);
        this.count = MessageFormat.format("{0}({1})", Keyword.COUNT.value,value);
    }
}
