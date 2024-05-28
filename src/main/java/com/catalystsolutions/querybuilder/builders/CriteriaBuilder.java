package com.catalystsolutions.querybuilder.builders;

import com.catalystsolutions.querybuilder.criterias.Criteria;
import com.catalystsolutions.querybuilder.enums.LogicalOperator;
import com.catalystsolutions.querybuilder.interfaces.ColumnCriteria;

import java.util.ArrayList;
import java.util.List;

public class CriteriaBuilder {
    private final List<Criteria> criteriaList;

    private CriteriaBuilder() {
        this.criteriaList = new ArrayList<Criteria>();
    }

    public static CriteriaBuilder getInstance() {
        return new CriteriaBuilder();
    }

    public void add(ColumnCriteria columnCriteria) {
        this.add(columnCriteria, null);
    }

    public void add(ColumnCriteria columnCriteria, LogicalOperator logicalOperator) {
        if (!columnCriteria.isEmpty()) {
            if (logicalOperator != null) {
                this.criteriaList.add(Criteria.getInstance(columnCriteria, logicalOperator));
            } else {
                this.criteriaList.add(new Criteria(columnCriteria));
            }
        }
    }

    public String build() {
        if (criteriaList.isEmpty()) {
            return "";
        }

        ArrayList<String> formattedCriteriaList = new ArrayList<>();
        for (int i = 0; i < criteriaList.size(); i++) {
            Criteria criteria = criteriaList.get(i);
            if (i == criteriaList.size() - 1) {
                formattedCriteriaList.add(criteria.toString(false));
            } else {
                formattedCriteriaList.add(criteria.toString(true));
            }
        }

        return String.join(" ", formattedCriteriaList);

    }

}
