package pl.konradklimczak.openstudies.service;

import org.springframework.stereotype.Service;
import pl.konradklimczak.openstudies.data.Subject.Subject;
import pl.konradklimczak.openstudies.data.Subject.SubjectDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {

    public SubjectDto getMySubjectToRest() {
        return Subject.builder().name("WDI").description("Nice subject!").build().asDto();
    }

    public List<SubjectDto> getMySubjects() {
        List<SubjectDto> subjectDtos = new ArrayList<SubjectDto>();
        for (int i = 0; i < 10; i++) {
            subjectDtos.add(Subject.builder().name("WDI" + i).description("Nice subject!").build().asDto());
        }
        return subjectDtos;
    }
}
