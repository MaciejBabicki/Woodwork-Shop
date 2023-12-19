package MaciejBabicki.controller;

import MaciejBabicki.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomePageController {

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public HomePageController(final ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/homePage")
    public String home(Model model){
        model.addAttribute("woodProducts", shoppingCartService.getAllWoodProducts());
        return "homePage";
    }

    @GetMapping("/add/{woodProductId}")
    public String addWoodProducToShoppingCart(@PathVariable("woodProductId") Long woodProductId, Model model){
        model.addAttribute("woodProducts", shoppingCartService.getAllWoodProducts());
        return "homePage";
    }
}
