package pl.konradklimczak.openstudies.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.konradklimczak.openstudies.data.Subject.SubjectDto;
import pl.konradklimczak.openstudies.service.DataService;

@RestController
public class OpenStudiesRestEndpoint {

    @Autowired
    private DataService dataService;

    @RequestMapping("/")
    public String getMyTestName () {
        return "Test";
    }

    @RequestMapping("/subject")
    public SubjectDto getMySubject () {
        return dataService.getMySubjectToRest();
    }
}
