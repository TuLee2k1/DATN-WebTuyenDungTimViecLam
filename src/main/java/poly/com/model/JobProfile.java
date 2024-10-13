package poly.com.model;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class JobProfile extends AbstractEntity{
    @Column(name = "fileCV")
    private String fileCV;

    @Column(name = "dateApply")
    private Date dateApply;

    @ManyToOne
    @JoinColumn(name = "id")
    private JobPost job_id;

    @ManyToOne
    @JoinColumn(name = "id")
    private Profile profile_id;

}
