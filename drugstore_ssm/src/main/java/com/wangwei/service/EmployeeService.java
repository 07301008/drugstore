package com.wangwei.service;

import com.wangwei.common.PageBean;
import com.wangwei.domain.Employee;

import java.util.List;

public interface EmployeeService {

    /**
     * 查询所有员工
     * @return
     */
    List<Employee> getAll();

    /**
     * 新增员工
     * @param employee
     */
    void add(Employee employee);

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     */
    PageBean<Employee> getPage(Integer currentPage, Integer pageSize);
}
