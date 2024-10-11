package poly.com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name= "pay")
public class Pay extends AbstractEntity{
    @Column(name = "amount")
    private Float amount;

    @Column(name = "paymentDate")
    private Date paymentDate;

    @Column(name = "paymentType")
    private String paymentType;
}
