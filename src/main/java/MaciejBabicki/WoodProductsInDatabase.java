package MaciejBabicki;

import MaciejBabicki.model.WoodProduct;
import MaciejBabicki.repository.WoodProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;
import java.util.List;

class WoodProductsInDatabase implements CommandLineRunner {
    private final WoodProductRepository woodProductRepository;

    @Autowired
    public WoodProductsInDatabase(WoodProductRepository woodProductRepository) {
        this.woodProductRepository = woodProductRepository;
    }

    @Override
    public void run(final String... args) throws Exception {
        woodProductRepository.saveAll(List.of(
                new WoodProduct("Windmill-LumberjackWithSaw", new BigDecimal("250"), "https://github.com/MaciejBabicki/Photos/blob/main/LumberjackWithSaw.png?raw=true"),
                new WoodProduct("Windmill-LumberjackWithAxe", new BigDecimal("250"), "https://github.com/MaciejBabicki/Photos/blob/main/LumberjackWithAxe.png?raw=true"),
                new WoodProduct("Goats", new BigDecimal("200"), "https://github.com/MaciejBabicki/Photos/blob/main/Goats.png?raw=true")
        ));
    }
}
