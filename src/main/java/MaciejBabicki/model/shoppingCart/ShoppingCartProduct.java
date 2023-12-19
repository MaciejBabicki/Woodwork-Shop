package MaciejBabicki.model.shoppingCart;

import MaciejBabicki.model.WoodProduct;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ShoppingCartProduct {

    private  final WoodProduct woodProduct;
    private int counter;
    private BigDecimal price;

    ShoppingCartProduct(WoodProduct woodProduct) {
        this.woodProduct = woodProduct;
        this.counter = 0;
        this.price = woodProduct.getPrice();
    }

    public void increaseCounter(){
        counter++;
        recalculate();
    }

    public void decreaseCounter(){
        if (counter>0) {
            counter--;
            recalculate();
        }
    }

    private void recalculate() {
        price= woodProduct.getPrice().multiply(new BigDecimal(counter));
    }

    public boolean isNoProducts(){
        return counter == 0;
    }

    public boolean idEquals(WoodProduct product) {
        return this.woodProduct.getId().equals(product.getId());
    }
}
