package ra.departmentservice.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DepartmentRequest {
    @NotBlank(message = "Không được để trống department id")
    private String departmentId;
    @NotBlank(message = "Không được để trống department name")
    private String departmentName;
}
