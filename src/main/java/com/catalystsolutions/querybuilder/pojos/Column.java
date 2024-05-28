package com.catalystsolutions.querybuilder.pojos;

import java.util.StringJoiner;

public class Column {
    public final ColumnActions Raw;
    public final ColumnActions Value;

    public Column(String table, String column) {
        this.Raw = new ColumnActions(column);
        this.Value= new ColumnActions(new StringJoiner(".").add(table).add(column).toString());
    }
}
