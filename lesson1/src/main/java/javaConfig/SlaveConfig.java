package javaConfig;

import javaConfig.context.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("javaConfig/context")
@Configuration
public class SlaveConfig {

    @Bean
    public Vehicle greengt() {
        return new Vehicle();
    }
}
