package javaConfig;

import javaConfig.context.Solar;
import javaConfig.context.Vehicle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.scan("context");
//        ctx.refresh();
        final ApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);

        final Vehicle tesla = ctx.getBean(Vehicle.class);
        System.out.println(tesla.getClass().getSimpleName() + " - "  + tesla.getEnergy().getClass().getSimpleName());

        final Vehicle audi = (Vehicle) ctx.getBean("audi");
        System.out.println(audi.getName() + " - " + audi.getEnergy().getClass().getSimpleName());

        final Vehicle greengt = (Vehicle) ctx.getBean("greengt");
        greengt.setName("greengt");
        greengt.setEnergy(ctx.getBean(Solar.class));
        System.out.println(greengt.getName() + " - " + greengt.getEnergy().getClass().getSimpleName());
    }
}
