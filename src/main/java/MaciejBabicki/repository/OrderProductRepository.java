package MaciejBabicki.repository;

import MaciejBabicki.model.order.OrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository <OrderedProduct, Long> {
}
