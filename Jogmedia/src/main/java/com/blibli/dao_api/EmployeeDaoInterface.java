package com.blibli.dao_api;

import com.blibli.model.Employee;

import java.util.List;

public interface EmployeeDaoInterface {
    List<Employee> getAllEmployee();
    List<Employee> search(String searchKey);
    void insertCategory(Employee E);
    Employee getIdEmployee(int idEmployee);
    void delete(int id);
    void softDeleteEmployee(int id);
}