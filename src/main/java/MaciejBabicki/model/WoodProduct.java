package MaciejBabicki.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class WoodProduct {

    @Id
    @GeneratedValue
    private Long id;
    private String type;
    private BigDecimal price;
    private String photoPath;

    public WoodProduct(String type, BigDecimal price, String photoPath) {
        this.type = type;
        this.price = price;
        this.photoPath = photoPath;
    }

}
