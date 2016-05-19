package pl.konradklimczak.openstudies.service;

import org.springframework.stereotype.Service;
import pl.konradklimczak.openstudies.data.Subject.Subject;
import pl.konradklimczak.openstudies.data.Subject.SubjectDto;

@Service
public class DataService {

    public SubjectDto getMySubjectToRest() {
        return Subject.builder().name("WDI").description("Nice subject!").build().asDto();
    }
}
