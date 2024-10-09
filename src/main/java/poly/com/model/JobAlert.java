package poly.com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name= "JobAlert")
public class JobAlert extends AbstractEntity{
    @Column(name = "status")
    private boolean status;

    @Column(name = "address")
    private String address;
}
