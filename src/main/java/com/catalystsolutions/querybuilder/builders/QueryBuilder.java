package com.catalystsolutions.querybuilder.builders;

import com.catalystsolutions.querybuilder.enums.Keyword;
import com.catalystsolutions.querybuilder.enums.Operation;
import com.catalystsolutions.querybuilder.pojos.Column;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class QueryBuilder {
    private final Operation operation;
    private final List<String> columns = new ArrayList<>();
    private final List<String> groupBy = new ArrayList<>();

    private String from;
    private String join;
    private String where;
    private Integer limit;
    private Integer offset;
    private String orderBy;

    private QueryBuilder(Operation operation) {
        this.operation = operation;
    }

    public static QueryBuilder getInstance(Operation operation) {
        return new QueryBuilder(operation);
    }

    public void select(Column... columns) {
        this.columns.addAll(Arrays.stream(columns).map(column -> column.Value.value).collect(Collectors.toList()));
    }


    public void count(Column... columns) {
        this.columns.addAll(Arrays.stream(columns).map(column -> column.Value.count).collect(Collectors.toList()));
    }


    public void from(String from) {
        this.from = from;
    }

    public void where(String criteria) {
        if (!criteria.isEmpty()) {
            this.where = MessageFormat.format("{0} {1}", Keyword.WHERE.value, criteria);
        } else {
            this.where = criteria;
        }
    }

    public void join(String join) {
        this.join = join;
    }

    public void orderBy(String orderBy) {
        if (!orderBy.isEmpty()) {
            this.orderBy = MessageFormat.format("{0} {1}", Keyword.ORDER_BY.value, orderBy);
        } else {
            this.orderBy = orderBy;
        }
    }

    public void groupBy(Column... groupBy) {
        this.groupBy.addAll(Arrays.stream(groupBy).map(column -> column.Value.value).collect(Collectors.toList()));
    }

    public void offset(Integer offset) {
        this.offset = offset;
    }

    public void limit(Integer limit) {
        this.limit = limit;
    }

    public String build() {
        StringJoiner stringJoiner = new StringJoiner(" ").add(this.operation.value);

        if (!this.columns.isEmpty()) {
            stringJoiner.add(String.join(",", this.columns));
        }

        stringJoiner.add(MessageFormat.format("{0} {1}", Keyword.FROM.value, this.from));

        if (this.join != null) {
            stringJoiner.add(join);
        }

        if (this.where != null) {
            stringJoiner.add(where);
        }

        if (!this.groupBy.isEmpty()) {
            stringJoiner.add(MessageFormat.format("{0} {1}", Keyword.GROUP_BY.value, String.join(",", this.groupBy)));
        }

        if (this.orderBy != null) {
            stringJoiner.add(this.orderBy);
        }

        if (this.limit != null) {
            stringJoiner.add(MessageFormat.format("{0} {1}", Keyword.LIMIT.value, this.limit));
        }

        if (this.offset != null) {
            stringJoiner.add(MessageFormat.format("{0} {1}", Keyword.OFFSET.value, this.offset));
        }


        return stringJoiner.toString();
    }
}
