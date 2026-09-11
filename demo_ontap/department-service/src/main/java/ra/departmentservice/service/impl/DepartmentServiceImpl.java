package ra.departmentservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.departmentservice.dto.request.DepartmentRequest;
import ra.departmentservice.dto.response.DepartmentResponse;
import ra.departmentservice.entity.Department;
import ra.departmentservice.repository.DepartmentRepository;
import ra.departmentservice.service.DepartmentService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentResponse> findAll() {
        return departmentRepository.findAll().stream().map(
                d -> DepartmentResponse.builder()
                        .departmentId(d.getDepartmentId())
                        .departmentName(d.getDepartmentName())
                        .build()
        ).toList();
    }

    @Override
    public DepartmentResponse findById(String id) {
        Department d = departmentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Không tồn tại phòng có mã " + id));
        return DepartmentResponse.builder()
                .departmentId(d.getDepartmentId())
                .departmentName(d.getDepartmentName())
                .build();
    }

    @Override
    public DepartmentResponse insert(DepartmentRequest departmentRequest) {
        Department d = Department.builder()
                .departmentId(departmentRequest.getDepartmentId())
                .departmentName(departmentRequest.getDepartmentName())
                .build();
        Department saved = departmentRepository.save(d);
        return DepartmentResponse.builder()
                .departmentId(saved.getDepartmentId())
                .departmentName(saved.getDepartmentName())
                .build();
    }

    @Override
    public DepartmentResponse update(String departmentId, DepartmentRequest departmentRequest) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new NoSuchElementException("Không tồn tại phòng ban có mã: " + departmentId));
        department.setDepartmentName(departmentRequest.getDepartmentName());
        Department saved = departmentRepository.save(department);
        return DepartmentResponse.builder()
                .departmentId(saved.getDepartmentId())
                .departmentName(saved.getDepartmentName())
                .build();
    }

    @Override
    public DepartmentResponse delete(String id) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Không tồn tại phòng ban có mã: " + id));
        departmentRepository.delete(department);
        return DepartmentResponse.builder()
                .departmentId(department.getDepartmentId())
                .departmentName(department.getDepartmentName())
                .build();
    }
}
