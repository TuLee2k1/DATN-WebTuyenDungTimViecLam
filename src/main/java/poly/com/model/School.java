package poly.com.model;

import jakarta.persistence.Column;

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
}
