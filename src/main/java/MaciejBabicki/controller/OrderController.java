package MaciejBabicki.controller;

import MaciejBabicki.model.WoodProductOperations;
import MaciejBabicki.objectDto.OrderDTO;
import MaciejBabicki.service.OrderService;
import MaciejBabicki.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
class OrderController {

    private final ShoppingCartService shoppingCartService;
    private final OrderService orderService;

    OrderController(ShoppingCartService shoppingCartService, OrderService orderService) {
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
    }
    @GetMapping
    public String showShoppingCart(){
        return "shoppingCartPage";
    }

    @GetMapping("/increase/{woodProductId}")
    public String increaseExactProduct(@PathVariable("woodProductId") Long woodProductId) throws Exception {
        shoppingCartService.Operation(woodProductId, WoodProductOperations.INCREASE);
        return "shoppingCartPage";
    }

    @GetMapping("/decrease/{woodProductId}")
    public String decreaseExactProduct(@PathVariable("woodProductId") Long woodProductId) throws Exception {
        shoppingCartService.Operation(woodProductId, WoodProductOperations.DECREASE);
        return "shoppingCartPage";
    }
     @GetMapping("/remove/{woodProductId}")
    public String removeAllProductFromShoppingCart(@PathVariable("woodProductId") Long woodProductId) throws Exception {
        shoppingCartService.Operation(woodProductId, WoodProductOperations.REMOVE);
        return "shoppingCartPage";
    }

    @GetMapping("Summary")
    public String showAllProductsInShoppingCart(){
        return "Summary";
    }

    @PostMapping("/saveorder")
    public String saveOrder(OrderDTO orderDTO){
        orderService.saveOrder(orderDTO);
        return "redirect:/";
    }
}
