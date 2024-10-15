package poly.com.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name= "company")
public class Company extends AbstractEntity {
    @Column(unique=true, name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "tax_code")
    private String tax_code;

    @Column(name = "logo")
    private String logo;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


}
