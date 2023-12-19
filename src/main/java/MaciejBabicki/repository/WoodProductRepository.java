package MaciejBabicki.repository;

import MaciejBabicki.model.WoodProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WoodProductRepository extends JpaRepository <WoodProduct, Long> {
}
