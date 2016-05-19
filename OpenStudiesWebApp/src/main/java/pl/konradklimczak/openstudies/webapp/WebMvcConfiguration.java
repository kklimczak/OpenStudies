package pl.konradklimczak.openstudies.webapp;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    public void addViewController(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:static/index.html");
    }
}
