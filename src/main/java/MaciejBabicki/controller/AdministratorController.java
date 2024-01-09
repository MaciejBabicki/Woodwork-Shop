package MaciejBabicki.controller;

import MaciejBabicki.model.WoodProduct;
import MaciejBabicki.model.order.Order;
import MaciejBabicki.repository.OrderRepository;
import MaciejBabicki.repository.WoodProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@CrossOrigin("*")
@Controller
@RequestMapping("/administrator")
class AdministratorController {

    private final WoodProductRepository woodProductRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public AdministratorController(WoodProductRepository woodProductRepository, OrderRepository orderRepository) {
        this.woodProductRepository = woodProductRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping
    private String administratorWeb(){
        return "administrator/addWoodProduct";
    }

    @PostMapping
    private String addWoodProduct(WoodProduct woodProduct){
        woodProductRepository.save(woodProduct);
        return "redirect:/";
    }

    @GetMapping("/showorders")
    @ResponseBody
    public List<Order> orderList(){
        return orderRepository.findAll();
    }
}
