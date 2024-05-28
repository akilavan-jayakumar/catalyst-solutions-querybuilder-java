package com.catalystsolutions.querybuilder.criterias;

import com.catalystsolutions.querybuilder.enums.Operator;
import com.catalystsolutions.querybuilder.interfaces.ColumnCriteria;
import com.catalystsolutions.querybuilder.pojos.Column;
import lombok.Getter;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class IntegerListColumnCriteria implements ColumnCriteria {
    private final String column;
    private final List<Integer> values;

    private IntegerListColumnCriteria(String column) {
        this.column = column;
        this.values = new ArrayList<>();
    }


    public static IntegerListColumnCriteria getInstance(Column column) {
        return new IntegerListColumnCriteria(column.Value.value);
    }

    public void add(Integer value) {
        this.values.add(value);
    }

    public void add(List<Integer> values) {
        this.values.addAll(values);
    }

    @Override
    public Boolean isEmpty() {
        return this.values.isEmpty();
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0} {1} ({2})", column, Operator.IN.value, this.values.stream().map(String::valueOf).collect(Collectors.joining(",")));
    }
}
