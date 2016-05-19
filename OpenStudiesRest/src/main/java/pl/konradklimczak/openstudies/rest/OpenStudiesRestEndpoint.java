package pl.konradklimczak.openstudies.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.konradklimczak.openstudies.data.Subject.SubjectDto;
import pl.konradklimczak.openstudies.service.DataService;

import java.util.List;

@RestController
public class OpenStudiesRestEndpoint {

    @Autowired
    private DataService dataService;

    @RequestMapping("/subject")
    public SubjectDto getMySubject () {
        return dataService.getMySubjectToRest();
    }

    @RequestMapping(value = "/subjects", method = RequestMethod.GET)
    public List<SubjectDto> getMySubjects () {
        return dataService.getMySubjects();
    }
}
