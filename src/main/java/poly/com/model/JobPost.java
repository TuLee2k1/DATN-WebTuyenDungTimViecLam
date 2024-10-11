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

    @Column(name = "salary")
    private float salary;

    @Temporal(TemporalType.DATE)
    @Column(name = "createDate")
    private Date createDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "expiredDate")
    private Date expiredDate;

    @Column(name = "status")
    private Boolean status;

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



}
