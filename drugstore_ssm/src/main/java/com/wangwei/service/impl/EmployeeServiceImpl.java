package com.wangwei.service.impl;

import com.wangwei.common.CustomException;
import com.wangwei.common.PageBean;
import com.wangwei.dao.EmployeeDao;
import com.wangwei.domain.Employee;
import com.wangwei.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    /**
     * 查询所有员工
     * @return
     */
    @Override
    public List<Employee> getAll() {
        List<Employee> employees = employeeDao.getAll();
        return employees;
    }

    /**
     * 新增员工
     * @param employee
     */
    @Override
    public void add(Employee employee) {
        employeeDao.add(employee);
    }

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     */
    @Override
    public PageBean<Employee> getPage(Integer currentPage, Integer pageSize, Employee employee) {
        // 计算开始索引
        int begin = (currentPage - 1) * pageSize;
        System.out.println("开始索引为：" + begin);
        // 计算查询条目数
        int size = pageSize;
        System.out.println("查询条目数为：" + size);
        // 查询姓名
        if (employee.getName() != null && employee.getName() != ""){
            try {
                String newName = new String(employee.getName().getBytes("ISO-8859-1"),"UTF-8");
                employee.setName(newName);
            } catch (UnsupportedEncodingException e) {
                throw new CustomException(e.getMessage());
            }
        }
        System.out.println("输入的参数：" + employee);
        // 获取当前页数据
        List<Employee> employees = employeeDao.getPage(begin, size, employee.getName(), employee.getSex());
        System.out.println("当前页数据为：" + employees);
        // 获取总记录数
        int totalCount = employeeDao.getTotalCount(employee.getName(), employee.getSex());
        System.out.println("总记录数为：" + totalCount);
        PageBean<Employee> pageBean = new PageBean<>();
        pageBean.setRows(employees);
        pageBean.setTotalCount(totalCount);
        return pageBean;
    }
}
