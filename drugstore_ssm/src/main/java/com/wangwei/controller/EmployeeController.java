package com.wangwei.controller;

import com.wangwei.common.PageBean;
import com.wangwei.common.Result;
import com.wangwei.domain.Employee;
import com.wangwei.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 新增员工
     * @return
     */
    @PostMapping
    public Result<String> add(@RequestBody Employee employee){
        System.out.println("新增员工");
        // 设置初始密码123456，需要进行md5加密处理
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));

        employee.setCreateTime(LocalDateTime.now().toString());
        employee.setUpdateTime(LocalDateTime.now().toString());

        // 获取当前登录用户id
//        Long empId = (Long) request.getSession().getAttribute("employee");

//        employee.setCreateUser(empId);
//        employee.setUpdateUser(empId);

        employeeService.add(employee);
        return Result.success("新增员工成功");
    }

    /**
     * 分页查询所有员工
     * @return
     */
    @GetMapping
    public Result<List<Employee>> getAll(){
        System.out.println("查询所有员工");
        List<Employee> employees = employeeService.getAll();
        Result<List<Employee>> success = Result.success(employees);
        System.out.println(employees);
        System.out.println(success);
        return success;
    }

    /**
     * 分页查询所有员工
     * @return
     */
    @GetMapping("/page")
    public Result<PageBean<Employee>> getPage(Integer currentPage, Integer pageSize, Employee employee){
        System.out.println("--------分页查询---------");
        PageBean<Employee> page = employeeService.getPage(currentPage, pageSize, employee);
        return Result.success(page);
    }
}
