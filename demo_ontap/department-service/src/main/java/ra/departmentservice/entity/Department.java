package ra.departmentservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "departments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Department {
    @Id
    @Column(name = "department_id", length = 15)
    private String departmentId;
    @Column(name = "department_name",length = 100, nullable = false,unique = true)
    private String departmentName;
}
