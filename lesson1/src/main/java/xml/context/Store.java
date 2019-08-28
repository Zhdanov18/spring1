package xml.context;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Store {

    @Autowired
    @Qualifier("first")
    private Resource battery;

    @Autowired
    @Qualifier("battery2")
    private Resource batteryTest;

    @Autowired
    private Resource fuel;

    @Autowired
    private Resource solar;
}
