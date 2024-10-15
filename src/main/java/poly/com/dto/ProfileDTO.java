package poly.com.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProfileDTO implements Serializable {
    private Long id;

    @NotEmpty(message = "name is require!")
    private String name;

    @NotEmpty(message = "email is require!")
    private String email;

    @NotEmpty(message = "phone is require!")
    private String phone;

    @NotEmpty(message = "address is require!")
    private String address;

    @NotEmpty(message = "sex is require!")
    private String sex;

    @NotEmpty(message = "dateOfBirth is require!")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
}
