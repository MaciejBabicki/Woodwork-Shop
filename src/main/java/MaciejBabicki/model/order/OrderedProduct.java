package MaciejBabicki.model.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class OrderedProduct {

    @Id
    @GeneratedValue
    private Long orderedProductId;
    private Long orderId;
    private int woodProductId;

    public OrderedProduct(Long orderedProductId, Long orderId, int woodProductId) {
        this.orderedProductId = orderedProductId;
        this.orderId = orderId;
        this.woodProductId = woodProductId;
    }
}
