package com.catalystsolutions.querybuilder.criterias;

import com.catalystsolutions.querybuilder.enums.Operator;
import com.catalystsolutions.querybuilder.interfaces.ColumnCriteria;
import com.catalystsolutions.querybuilder.pojos.Column;
import lombok.Getter;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Getter
public class StringListColumnCriteria implements ColumnCriteria {
    private final String column;
    private final List<String> values;

    private StringListColumnCriteria(String column) {
        this.column = column;
        this.values = new ArrayList<>();
    }

    public static StringListColumnCriteria getInstance(Column column) {
        return new StringListColumnCriteria(column.Value.value);
    }

    public void add(String value) {
        this.values.add(value);
    }

    public void addAll(List<String> values) {
        this.values.addAll(values);
    }

    @Override
    public Boolean isEmpty() {
        return this.values.isEmpty();
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0} {1} ({2})", column, Operator.IN.value, String.join(",", this.values));
    }
}
