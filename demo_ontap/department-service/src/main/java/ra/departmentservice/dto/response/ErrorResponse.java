package ra.departmentservice.dto.response;

import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ErrorResponse <T>{
    private LocalDateTime timestamp;
    T errors;
}
