package MaciejBabicki.model.shoppingCart;

import MaciejBabicki.model.WoodProduct;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ShoppingCartProduct {

    private  final WoodProduct woodProduct;
    private int counter;
    private BigDecimal price= BigDecimal.valueOf(0);

    public ShoppingCartProduct(WoodProduct woodProduct) {
        this.woodProduct = woodProduct;
        this.counter = 1;
        this.price = woodProduct.getPrice();
    }

    public void increaseCounter() {
        counter++;
        recalculate();
    }

    public void decreaseCounter() {
        if (counter>0) {
            counter--;
            recalculate();
        }
    }

    //price per unit x units
    private void recalculate() {
        if (price!=null) {
            price = woodProduct.getPrice().multiply(new BigDecimal(counter));
        }else {
            throw new IllegalStateException("price can't be null");
        }
    }



    //deleting all product from cart
    public boolean isNoProducts(){
        return counter == 0;
    }

    // woodProduct id = ShoppingCartProduct woodProduct id
    public boolean idEquals(WoodProduct woodProduct) {
        return this.woodProduct.getId().equals(woodProduct.getId());
    }
}
