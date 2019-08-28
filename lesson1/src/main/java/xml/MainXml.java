package xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xml.context.Resource;
import xml.context.Store;

public class MainXml {
    public static void main(String[] args) {
        final ApplicationContext ctx = new ClassPathXmlApplicationContext("mainContext.xml");

        final Store store = ctx.getBean(Store.class);
        System.out.println(store.getBattery());
        System.out.println(store.getBatteryTest());

        final Resource battery = ctx.getBean("batteryLast", Resource.class);
        System.out.println(battery);
//        final Resource battery1 = ctx.getBean("battery", Resource.class);
//        System.out.println(battery1);

        System.out.println(store.getFuel());
        System.out.println(store.getSolar());
    }
}
