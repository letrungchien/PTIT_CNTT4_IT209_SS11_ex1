package ra.employeeservice.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ra.employeeservice.dto.response.APIResponse;
import ra.employeeservice.dto.response.DepartmentResponse;

@FeignClient(name = "department-service")
public interface DepartmentServiceCall {
    @GetMapping("/api/v1/departments/{departmentId}")
    ResponseEntity<APIResponse<DepartmentResponse>> getById(@PathVariable String departmentId);
}
