package com.wangwei.dao;

import com.wangwei.domain.Employee;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;


public interface EmployeeDao {

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
     * @param begin 起始索引
     * @param size 每页显示数量
     * @return
     */
    List<Employee> getPage(@Param("begin") Integer begin, @Param("size") Integer size
            , @Param("name") String name, @Param("sex") String sex);

    /**
     * 查询总记录数
     * @return
     */
    int getTotalCount(@Param("name") String name, @Param("sex") String sex);
}
