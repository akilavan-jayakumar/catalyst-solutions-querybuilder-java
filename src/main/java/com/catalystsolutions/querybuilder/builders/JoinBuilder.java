package com.catalystsolutions.querybuilder.builders;


import com.catalystsolutions.querybuilder.pojos.Join;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoinBuilder {
    private final List<Join> joins;

    private JoinBuilder(){
        this.joins = new ArrayList<>();
    }

    public void add(Join ...joins){
        this.joins.addAll(Arrays.stream(joins).collect(Collectors.toList()));
    }

    public String build(){
        return this.joins.stream().map(Join::toString).collect(Collectors.joining(" "));
    }

    public static JoinBuilder getInstance(){
        return new JoinBuilder();
    }
}
