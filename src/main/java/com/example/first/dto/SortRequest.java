package com.example.first.dto;

import org.springframework.data.domain.Sort;

public class SortRequest {

    private String sortProp;

    private Sort.Direction direction;

    public SortRequest() {
    }

    public String getSortProp() {
        return sortProp;
    }

    public void setSortProp(String sortProp) {
        this.sortProp = sortProp;
    }

    public Sort.Direction getDirection() {
        return direction;
    }

    public void setDirection(Sort.Direction direction) {
        this.direction = direction;
    }
}
