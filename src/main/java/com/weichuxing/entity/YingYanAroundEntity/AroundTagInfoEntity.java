package com.weichuxing.entity.YingYanAroundEntity;

import java.util.List;

public class AroundTagInfoEntity {

    private Integer status;

    private String message;

    private Long size;

    private Long total;

    private List<AroundEntities> entities;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public List<AroundEntities> getEntities() {
        return entities;
    }

    public void setEntities(List<AroundEntities> entities) {
        this.entities = entities;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
