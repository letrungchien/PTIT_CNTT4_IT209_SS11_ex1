package ra.departmentservice.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.departmentservice.dto.request.DepartmentRequest;
import ra.departmentservice.dto.response.APIResponse;
import ra.departmentservice.dto.response.DepartmentResponse;
import ra.departmentservice.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<APIResponse<List<DepartmentResponse>>> getAll() {
        return new ResponseEntity<>(new APIResponse<>(
                true,
                "Lấy danh sách phòng ban thành công",
                departmentService.findAll(),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<APIResponse<DepartmentResponse>> getById(@PathVariable String departmentId) {
        return new ResponseEntity<>(new APIResponse<>(
                true,
                "Lấy thông tin phòng ban có mã " + departmentId + " thành công",
                departmentService.findById(departmentId),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<APIResponse<DepartmentResponse>> save(@RequestBody DepartmentRequest departmentRequest) {
        return new ResponseEntity<>(new APIResponse<>(
                true,
                "Thêm mới phòng ban " + departmentRequest.getDepartmentName() + " thành công",
                departmentService.insert(departmentRequest),
                null,
                HttpStatus.CREATED
        ), HttpStatus.CREATED);
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<APIResponse<DepartmentResponse>> update(@PathVariable String departmentId, @RequestBody DepartmentRequest departmentRequest) {
        return new ResponseEntity<>(new APIResponse<>(
                true,
                "Cập nhật thông tin phòng ban " + departmentRequest.getDepartmentName() + " thành công",
                departmentService.update(departmentId, departmentRequest),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<APIResponse<DepartmentResponse>> delete(@PathVariable String departmentId) {
        return new ResponseEntity<>(new APIResponse<>(
                true,
                "Xóa thông tin phòng ban có mã: " + departmentId + " thành công",
                departmentService.delete(departmentId),
                null,
                HttpStatus.NO_CONTENT
        ), HttpStatus.NO_CONTENT);
    }
}
