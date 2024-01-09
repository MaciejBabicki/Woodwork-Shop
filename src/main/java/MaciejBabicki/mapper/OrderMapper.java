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

    //Mapping the OrderDTO to Order
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

    //Converting data from the shopping cart to list of objects OrderedProduct
    public static List<OrderedProduct> mapToOrderedProduct(ShoppingCartDataStructure cart, Order order){
        List<OrderedProduct> orderedProducts = new ArrayList<>();
        for(ShoppingCartProduct ii: cart.getProductsToBuy()){
            orderedProducts.add(new OrderedProduct(order.getOrderId(), ii.getWoodProduct().getId(), ii.getCounter()));
        }
        return orderedProducts;
    }
}
