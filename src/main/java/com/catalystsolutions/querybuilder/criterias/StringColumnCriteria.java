package com.catalystsolutions.querybuilder.criterias;

import com.catalystsolutions.querybuilder.enums.Operator;
import com.catalystsolutions.querybuilder.interfaces.ColumnCriteria;
import com.catalystsolutions.querybuilder.pojos.Column;
import lombok.Getter;

import java.text.MessageFormat;

@Getter
public class StringColumnCriteria implements ColumnCriteria {
    private final String column;
    private String value;

    private StringColumnCriteria(String column) {
        this.value = "";
        this.column = column;
    }

    public static StringColumnCriteria getInstance(Column column) {
        return new StringColumnCriteria(column.Value.value);
    }

    public void equalTo(String value) {
        this.value = value;
    }

    public void contains(String value) {
        this.equalTo(MessageFormat.format("*{0}*", value));
    }

    public void startsWith(String value) {
        this.equalTo(MessageFormat.format("*{0}", value));
    }

    public void endsWith(String value) {
        this.equalTo(MessageFormat.format("*{0}", value));
    }

    @Override
    public Boolean isEmpty() {
        return this.value.isEmpty();
    }

    @Override
    public String toString() {

        return MessageFormat.format("{0} {1} {2}", column, Operator.LIKE.value, value);

    }

}
