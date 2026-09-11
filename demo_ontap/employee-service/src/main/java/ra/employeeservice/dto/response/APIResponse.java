package ra.employeeservice.dto.response;

import lombok.*;
import org.springframework.http.HttpStatus;
import ra.departmentservice.dto.response.ErrorResponse;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class APIResponse <T>{
    private boolean success;
    private String message;
    private T data;
    private ErrorResponse<T> error;
    private HttpStatus status;
}
