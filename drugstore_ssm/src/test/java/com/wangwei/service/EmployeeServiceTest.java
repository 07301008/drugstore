package com.wangwei.service;

import com.wangwei.common.PageBean;
import com.wangwei.common.Result;
import com.wangwei.config.SpringConfig;
import com.wangwei.dao.EmployeeDao;
import com.wangwei.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class EmployeeServiceTest {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private EmployeeService employeeService;

    /**
     * 查询所有数据
     */
    @Test
    public void testGetAll(){
        List<Employee> employees = employeeDao.getAll();
        System.out.println(employees);
        List<Employee> employees1 = employeeService.getAll();
        System.out.println(employees1);
    }

    /**
     * 查询当前页数据
     */
    @Test
    public void testGetPage() {
        List<Employee> employees = employeeDao.getPage(0, 5);
        System.out.println(employees);
        PageBean<Employee> page = employeeService.getPage(1, 5);
        System.out.println(page);
    }
}
