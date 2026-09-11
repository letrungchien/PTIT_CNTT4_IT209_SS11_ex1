package ra.departmentservice.service;

import ra.departmentservice.dto.request.DepartmentRequest;
import ra.departmentservice.dto.response.DepartmentResponse;
import ra.departmentservice.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<DepartmentResponse> findAll();
    DepartmentResponse findById(String id);
    DepartmentResponse insert(DepartmentRequest departmentRequest);
    DepartmentResponse update(String departmentId, DepartmentRequest departmentRequest);
    DepartmentResponse delete(String id);
}
