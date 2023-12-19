package MaciejBabicki.service;

import MaciejBabicki.objectDto.OrderDTO;
import MaciejBabicki.mapper.OrderMapper;
import MaciejBabicki.model.order.Order;
import MaciejBabicki.model.shoppingCart.ShoppingCart;
import MaciejBabicki.repository.OrderProductRepository;
import MaciejBabicki.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final ShoppingCart cart;
    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;

    @Autowired
    public OrderService(ShoppingCart cart, OrderRepository orderRepository, OrderProductRepository orderProductRepository) {
        this.cart = cart;
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
    }

    public void saveOrder(OrderDTO dto){
        Order order = OrderMapper.mapToOrder(dto);
        orderRepository.save(order);
        orderProductRepository.saveAll(OrderMapper.mapToOrderProduct(cart, order));
        cart.deleteProductsFromCart();
    }
}
