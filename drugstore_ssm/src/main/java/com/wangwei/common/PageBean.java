package com.wangwei.common;

import lombok.Data;

import java.util.List;

@Data
// 分页查询的JavaBean
public class PageBean<T> {
    // 总记录数
    private int totalCount;

    // 当前页的数据
    private List<T> rows;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
