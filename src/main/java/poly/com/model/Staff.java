package poly.com.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name= "Staff")
public class Staff extends AbstractEntity{
    @Column(name = "fullName")
    private String fullName;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "position")
    private String position;

    @Column(name = "address")
    private String address;

    @Column(name = "dob")
    private Date dob;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user_id;
}
