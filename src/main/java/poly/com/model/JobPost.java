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

    @Column(name = "jobStatus")
    private String jobStatus;

    @Column(name = "jobRequirement")
    private String jobRequirement;

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



}
