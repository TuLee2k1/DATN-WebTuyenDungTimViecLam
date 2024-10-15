package poly.com.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class StaffDto {

    @NotBlank(message = "Full name is required")
    @Size(min = 5, max = 50, message = "Full name must be between 5 and 50 characters")
    String fullName;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})\\b", message = "Phone number is invalid")
    String phoneNumber;

    @NotNull(message = "Position is required")
    String position;

    @NotBlank(message = "Address is required")
    String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dob;


}
