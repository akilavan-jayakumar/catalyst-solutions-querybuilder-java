package com.catalystsolutions.querybuilder.criterias;

import com.catalystsolutions.querybuilder.enums.Operator;
import com.catalystsolutions.querybuilder.interfaces.ColumnCriteria;
import com.catalystsolutions.querybuilder.pojos.Column;

import java.text.MessageFormat;

public class BooleanColumnCriteria implements ColumnCriteria {
    private final String column;
    private Boolean value;

    private BooleanColumnCriteria(String column) {
        this.column = column;
    }

    public static BooleanColumnCriteria getInstance(Column column) {
        return new BooleanColumnCriteria(column.Value.value);
    }

    public void equalTo(Boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0} {1} {2}", column, Operator.EQ.value, value);
    }

    @Override
    public Boolean isEmpty() {
        return this.value == null;
    }

}
