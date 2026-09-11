package ra.employeeservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.employeeservice.entity.Employee;
import ra.employeeservice.openfeign.DepartmentServiceCall;
import ra.employeeservice.repository.EmployeeRepository;
import ra.employeeservice.service.EmployeeService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentServiceCall  departmentServiceCall;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Không tồn tại nhân viên có mã "+id));
    }

    @Override
    public Employee insertEmployee(Employee employee) {
        //Phải check departmentId có tồn tại không?
        if(departmentServiceCall.getById(employee.getDepartmentId()).getBody().getData().getDepartmentId()==null){
            throw new NoSuchElementException("Mã phòng "+employee.getDepartmentId()+" không tồn tại!");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        employeeRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Không tồn tại nhân viên có mã "+id));

        employee.setEmpId(id);
        //Phải check departmentId có tồn tại không?
        if(departmentServiceCall.getById(employee.getDepartmentId()).getBody().getData().getDepartmentId()==null){
            throw new NoSuchElementException("Mã phòng "+employee.getDepartmentId()+" không tồn tại!");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Không tồn tại nhân viên có mã "+id));
        employeeRepository.deleteById(id);
    }
}
