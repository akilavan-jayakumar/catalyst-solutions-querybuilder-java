package com.catalystsolutions.querybuilder.criterias;

import com.catalystsolutions.querybuilder.enums.LogicalOperator;
import com.catalystsolutions.querybuilder.interfaces.ColumnCriteria;
import lombok.Getter;

import java.text.MessageFormat;

@Getter
public class Criteria {
    private final LogicalOperator logicalOperator;
    private final ColumnCriteria columnCriteria;

    public Criteria(ColumnCriteria columnCriteria) {
        this.logicalOperator = LogicalOperator.AND;
        this.columnCriteria = columnCriteria;
    }

    private Criteria(ColumnCriteria columnCriteria, LogicalOperator logicalOperator) {
        this.logicalOperator = logicalOperator;
        this.columnCriteria = columnCriteria;
    }

    public static Criteria getInstance(ColumnCriteria columnCriteria) {
        return new Criteria(columnCriteria, LogicalOperator.AND);
    }

    public static Criteria getInstance(ColumnCriteria columnCriteria, LogicalOperator logicalOperator) {
        return new Criteria(columnCriteria, logicalOperator);
    }

    public String toString(Boolean includeOperator) {
        if (includeOperator) {
            return MessageFormat.format("{0} {1}", this.columnCriteria.toString(), this.logicalOperator.value);
        } else {
            return this.columnCriteria.toString();
        }
    }
}
