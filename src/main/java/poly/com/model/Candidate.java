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
@Table(name= "candidate")
public class Candidate extends AbstractEntity{
    @Column(name = "fileCV")
    private String fileCV;

    @Column(name = "image")
    private String image;

    @Column(name = "status")
    private boolean status;

}
