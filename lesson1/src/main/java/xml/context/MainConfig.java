package xml.context;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MainConfig {

    @Bean("battery2")
    public Resource battery2() {
        return new Battery();
    }
}
