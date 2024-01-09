package MaciejBabicki.model.shoppingCart;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Data
public class ShoppingCartDataStructure {
    public List<ShoppingCartProduct> productsToBuy = new ArrayList<>();
    int counter = 1;
    protected BigDecimal sum = BigDecimal.ZERO;
}
