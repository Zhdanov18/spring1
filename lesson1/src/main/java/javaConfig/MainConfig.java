package javaConfig;

import javaConfig.context.Fuel;
import javaConfig.context.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({SlaveConfig.class})
@Configuration
public class MainConfig {

    @Bean
    public Vehicle audi() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("audi");
        vehicle.setEnergy(new Fuel());
        return vehicle;
    }
}
