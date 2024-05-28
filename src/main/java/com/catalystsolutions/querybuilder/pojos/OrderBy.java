package com.catalystsolutions.querybuilder.pojos;

import com.catalystsolutions.querybuilder.enums.SortOrder;

import java.text.MessageFormat;

public class OrderBy {
    public final String column;
    public final SortOrder sortOrder;

    private OrderBy(String column, SortOrder sortOrder) {
        this.column = column;
        this.sortOrder = sortOrder;
    }

    public static OrderBy getInstance(Column column, SortOrder sortOrder) {
        return new OrderBy(column.Value.value, sortOrder);
    }

    public static OrderBy getInstance(Column column) {
        return new OrderBy(column.Value.value, SortOrder.ASC);
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0} {1}", column, sortOrder.value);
    }
}
