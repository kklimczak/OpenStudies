package pl.konradklimczak.openstudies.rest;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class OpenStudiesRestEndpoint {
    @RequestMapping("/")
    public String getMyTestName () {
        return "Test";
    }
}
