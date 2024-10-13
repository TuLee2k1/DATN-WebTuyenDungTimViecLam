package poly.com.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name= "JobPost")
public class JobPost extends AbstractEntity{
    @Column(name = "jobTitle")
    private String jobTitle;

    @Column(name = "jobDescription")
    private String jobDescription;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "jobRequire")
    private String jobRequire;

    @Temporal(TemporalType.DATE)
    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "minSalary")
    private float minSalary;

    @Column(name = "maxSalary")
    private float maxSalary;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "confirm")
    private Boolean confirm;

    @Column(name = "city")
    private String city;

    @ManyToOne
    @JoinColumn(name = "id")
    private JobCategory jobCategory_id;

   @ManyToOne
    @JoinColumn(name = "id")
    private Company company_id;



}
