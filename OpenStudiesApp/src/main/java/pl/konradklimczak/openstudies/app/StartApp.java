package pl.konradklimczak.openstudies.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("pl.konradklimczak.openstudies")
@EntityScan(basePackages = "pl.konradklimczak.openstudies.data")
@EnableJpaRepositories(basePackages = "pl.konradklimczak.openstudies.data")
public class StartApp {
    public static void main(String[] args) {
        SpringApplication.run(StartApp.class, args);
    }


}
