package poly.com.model;

import jakarta.persistence.Column;

import java.util.Date;

public class JobProfile extends AbstractEntity{
    @Column(name = "fileCV")
    private String fileCV;

    @Column(name = "dateApply")
    private Date dateApply;
}
