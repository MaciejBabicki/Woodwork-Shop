package MaciejBabicki.model.order;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long orderId;
    private String firstName;
    private String lastName;
    private String street;
    private String postCode;
    private String city;
    private LocalDateTime done;

    @OneToMany
    @JoinColumn(name = "orderId")
    private List<OrderedProduct> orderedProducts;
}
