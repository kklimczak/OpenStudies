package pl.konradklimczak.openstudies.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("pl.konradklimczak.openstudies")
public class StartApp {
    public static void main(String[] args) {
        SpringApplication.run(StartApp.class, args);
    }


}
