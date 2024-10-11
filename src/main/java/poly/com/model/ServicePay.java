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
@Table(name= "ServicePay")
public class ServicePay extends AbstractEntity{
    @Column(name = "serviceDesc")
    private String serviceDesc;

    @Column(name = "status")
    private Boolean Status;
}
