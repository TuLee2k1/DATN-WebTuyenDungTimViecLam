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
@Table(name= "JobApplication")
public class JobApplication extends AbstractEntity{
    @Temporal(TemporalType.DATE)
    @Column(name = "dateApply")
    private Date dateApply;

    @Column(name = "status")
    private String status;

}
