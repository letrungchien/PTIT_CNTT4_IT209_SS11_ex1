package ra.employeeservice.service;

import ra.employeeservice.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee>  findAll();
    Employee findById(Long id);
    Employee insertEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee employee);
    void deleteById(Long id);
}
