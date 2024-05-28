package com.catalystsolutions.querybuilder.builders;

import com.catalystsolutions.querybuilder.pojos.OrderBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrderByBuilder {
    private final List<OrderBy> orderByList;

    public OrderByBuilder(){
        orderByList = new ArrayList<>();
    }

    public void add(OrderBy ...orderByList){
        this.orderByList.addAll(Arrays.stream(orderByList).collect(Collectors.toList()));
    }

    public String build(){
        if(orderByList.isEmpty()){
            return "";
        }

        return orderByList.stream().map(OrderBy::toString).collect(Collectors.joining(","));
    }

    public static OrderByBuilder getInstance(){
        return new OrderByBuilder();
    }
}
