package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ashokit.beans.Motor;
import in.ashokit.config.Appconfig;

@SpringBootApplication

public class BeanlifecycleApplication {

    public static void main(String[] args) {
        ApplicationContext ctxt = SpringApplication.run(BeanlifecycleApplication.class, args);

        Motor mc = ctxt.getBean(Motor.class);
        mc.doWork();
    }
}

