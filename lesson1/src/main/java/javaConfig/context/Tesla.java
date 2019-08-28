package javaConfig.context;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
@Setter
@Getter
public class Tesla extends Vehicle{

    @Override
    @Autowired
    public void setName(@Value("tesla") String name) {
        super.setName(name);
    }

    @Override
    @Autowired
    @Qualifier("battery")
    public void setEnergy(Resource resource) {
        super.setEnergy(resource);
    }
}
