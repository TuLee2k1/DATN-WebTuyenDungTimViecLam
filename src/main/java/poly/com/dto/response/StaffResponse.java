package poly.com.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import poly.com.model.User;

import java.time.LocalDate;

@Data
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class StaffResponse {
    Long id;
    String fullName;
    String phoneNumber;
    String position;
    String address;
    LocalDate dob;
    Long user_id;

}
