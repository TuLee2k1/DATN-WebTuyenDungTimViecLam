package poly.com.model;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class School extends AbstractEntity{
    @Column(name = "schoolName")
    private String schoolName;

    @Column(name = "degree")
    private String degree;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "GPA")
    private float GPA;

    @ManyToOne
    @JoinColumn(name = "id")
    private Profile profile_id;


}
