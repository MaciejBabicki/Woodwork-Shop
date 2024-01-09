package MaciejBabicki.service;

import MaciejBabicki.model.WoodProductOperations;
import MaciejBabicki.model.WoodProduct;
import MaciejBabicki.model.shoppingCart.ShoppingCart;
import MaciejBabicki.repository.WoodProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService {
private final WoodProductRepository woodProductRepository;
private final ShoppingCart cart;

    @Autowired
    public ShoppingCartService(WoodProductRepository woodProductRepository, ShoppingCart cart) {
        this.woodProductRepository = woodProductRepository;
        this.cart = cart;
    }

    public List<WoodProduct> getAllWoodProducts() {
        return woodProductRepository.findAll();
    }

    public void Operation(Long woodProductId, WoodProductOperations operation) {
        Optional<WoodProduct> optionalWoodProduct = woodProductRepository.findById(woodProductId);
        if (optionalWoodProduct.isPresent()){
            WoodProduct woodProduct = optionalWoodProduct.get();
            switch (operation){
                case INCREASE -> cart.addOneProduct(woodProduct);
                case DECREASE -> cart.quitOneProduct(woodProduct);
                case REMOVE -> cart.deleteProductsFromCart();
                default -> throw new IllegalArgumentException("Wrong command");
            }
        }
    }
}
