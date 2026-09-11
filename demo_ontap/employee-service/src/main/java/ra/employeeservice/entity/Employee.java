package ra.employeeservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long empId;
    @Column(name = "employee_name", length = 70)
    private String empName;
    private Boolean gender;
    private LocalDate birthday;
    private String address;
    private String departmentId;
}
