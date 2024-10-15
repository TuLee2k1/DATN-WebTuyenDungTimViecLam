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
@Table(name= "UserRole")
public class UserRole extends AbstractEntity{
    @Column(name = "role")
    private boolean role;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private User user_id;
}
