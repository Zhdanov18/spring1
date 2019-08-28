package javaConfig.context;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Vehicle implements Resource {
    private String name;
    private Resource energy;
}
