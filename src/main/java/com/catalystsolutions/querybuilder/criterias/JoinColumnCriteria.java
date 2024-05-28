package com.catalystsolutions.querybuilder.criterias;

import com.catalystsolutions.querybuilder.enums.Operator;
import com.catalystsolutions.querybuilder.interfaces.ColumnCriteria;
import com.catalystsolutions.querybuilder.pojos.Column;
import lombok.Getter;

import java.text.MessageFormat;

@Getter
public class JoinColumnCriteria implements ColumnCriteria {
    private final String source;
    private final String target;

    private JoinColumnCriteria(String source, String target) {
        this.source = source;
        this.target = target;
    }

    public static JoinColumnCriteria getInstance(Column source, Column target) {
        return new JoinColumnCriteria(source.Value.value, target.Value.value);
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0} {1} {2}", source, Operator.EQ.value, target);
    }

}
