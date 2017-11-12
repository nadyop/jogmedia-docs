package com.Jogmedia.Jogmedia.service;

import com.Jogmedia.Jogmedia.dao_api.EmployeeDaoInterface;
import com.Jogmedia.Jogmedia.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeService {
    @Autowired
    EmployeeDaoInterface employeeDaoInterface;
    public List<Employee> showAllEmployee(){
        List<Employee> temp=employeeDaoInterface.getAllEmployee();
        return temp;
    }
    public void save(Employee e){
        employeeDaoInterface.insertCategory(e);

    }
    public Employee getIdEmployee(Integer id){
        Employee idEmp= employeeDaoInterface.getIdEmployee(id);
        return idEmp;
    }
    public void deleteEmployee(Integer id){
        employeeDaoInterface.delete(id);
    }
}
