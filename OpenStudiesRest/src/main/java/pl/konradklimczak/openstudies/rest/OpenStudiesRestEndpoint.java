package pl.konradklimczak.openstudies.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.konradklimczak.openstudies.data.Subject.SubjectDto;
import pl.konradklimczak.openstudies.service.DataService;
import pl.konradklimczak.openstudies.utils.ExceptionsHandler.Exceptions.NoElementException;

import java.util.List;

@RestController
public class OpenStudiesRestEndpoint {

    @Autowired
    private DataService dataService;

    @RequestMapping(value = "/subject", method = RequestMethod.GET)
    public List<SubjectDto> getAllSubjects () {
        return dataService.getAllSubjects();
    }

    @RequestMapping(value = "/subject/{id}", method = RequestMethod.GET)
    public SubjectDto getSubjectById (@PathVariable Long id) throws NoElementException {
        return dataService.getSubjectById(id);
    }

    @RequestMapping(value = "/subject", method = RequestMethod.PUT)
    public SubjectDto createOrUpdateSubject(@RequestBody SubjectDto subjectDto) {
        return dataService.createOrUpdateSubject(subjectDto);
    }

    @RequestMapping(value = "/subject/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSubjectById(@PathVariable Long id) throws NoElementException {
        dataService.deleteSubjectById(id);
    }
}
