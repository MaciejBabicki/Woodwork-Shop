package MaciejBabicki.mapper;

import MaciejBabicki.objectDto.OrderDTO;
import MaciejBabicki.model.order.Order;
import MaciejBabicki.model.order.OrderedProduct;
import MaciejBabicki.model.shoppingCart.ShoppingCartDataStructure;
import MaciejBabicki.model.shoppingCart.ShoppingCartProduct;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class OrderMapper {

    public static Order mapToOrder(OrderDTO orderDTO){
        return Order.builder()
                .firstName(orderDTO.getFirstName())
                .lastName(orderDTO.getLastName())
                .street(orderDTO.getStreet())
                .postCode(orderDTO.getStreet())
                .city(orderDTO.getCity())
                .done(LocalDateTime.now())
                .build();
    }

    public static List<OrderedProduct>mapToOrderProduct(ShoppingCartDataStructure cart, Order order){
        List<OrderedProduct> orderedProducts = new ArrayList<>();
        for(ShoppingCartProduct ii: cart.getProductsToBuy()){
            orderedProducts.add(new OrderedProduct(order.getOrderId(), ii.getWoodProduct().getId(), ii.getCounter()));
        }
        return orderedProducts;
    }
}
