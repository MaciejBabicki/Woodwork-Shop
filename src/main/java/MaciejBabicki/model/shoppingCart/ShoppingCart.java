package MaciejBabicki.model.shoppingCart;

import MaciejBabicki.model.WoodProduct;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart extends ShoppingCartDataStructure {


    public void addOneProduct(WoodProduct product){
        getShoppingCartProduct(product).ifPresentOrElse(
                ShoppingCartProduct::increaseCounter,
                () -> productsToBuy.add(new ShoppingCartProduct(product))
        );
    }

    public void deleteProductsFromCart(){
        productsToBuy.clear();
        counter = 0;
        sum = BigDecimal.ZERO;
    }

    public void quitOneProduct(WoodProduct product){
        Optional<ShoppingCartProduct> optionalShoppingCartProduct = getShoppingCartProduct(product);
        if (optionalShoppingCartProduct. isPresent()){
            ShoppingCartProduct shoppingCartProduct = optionalShoppingCartProduct.get();
            shoppingCartProduct.decreaseCounter();
            if (shoppingCartProduct.isNoProducts()){
                deleteProductsfromCart(product);
            }else {
                CalculateBetter();
            }
        }
    }

    private void deleteProductsfromCart(WoodProduct product) {
        productsToBuy.removeIf(i -> i.idEquals(product));
        CalculateBetter();
    }

    private void CalculateBetter() {
        sum = productsToBuy.stream()
                .map(ShoppingCartProduct::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        counter = productsToBuy.stream()
                .mapToInt(ShoppingCartProduct::getCounter)
                .reduce(0, Integer::sum);
    }

    private Optional<ShoppingCartProduct> getShoppingCartProduct(WoodProduct product) {
        return productsToBuy.stream()
                .filter(i -> i.idEquals(product))
                .findFirst();
    }
}
