package com.catalystsolutions.querybuilder.pojos;

import com.catalystsolutions.querybuilder.enums.JoinType;
import com.catalystsolutions.querybuilder.enums.Operator;
import lombok.Getter;

import java.text.MessageFormat;

@Getter
public class Join {
    private final String table;
    private final String criteria;
    private final JoinType joinType;

    private Join(String table, String criteria) {
        this.table = table;
        this.criteria = criteria;
        this.joinType = JoinType.INNER_JOIN;
    }

    private Join(String table, String criteria, JoinType joinType) {
        this.table = table;
        this.joinType = joinType;
        this.criteria = criteria;
    }

    public static Join getInstance(String table, String criteria) {
        return new Join(table, criteria);
    }

    public static Join getInstance(String table, String criteria, JoinType joinType) {
        return new Join(table, criteria, joinType);
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0} {1} {2} {3}", joinType.value, table, Operator.ON.value, criteria);
    }
}
