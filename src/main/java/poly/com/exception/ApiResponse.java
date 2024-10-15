package poly.com.exception;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@JsonPropertyOrder({"status", "message", "Result"})
public class ApiResponse<T> {

    int status;
    String message;
    T Result;

    public ApiResponse() {
    }

    public ApiResponse(int status, String message, T result) {
        this.status = status;
        this.message = message;
        Result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return Result;
    }

    public void setResult(T result) {
        Result = result;
    }
}
