package pl.konradklimczak.openstudies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.konradklimczak.openstudies.data.Subject.Subject;
import pl.konradklimczak.openstudies.data.Subject.SubjectDto;
import pl.konradklimczak.openstudies.data.Subject.SubjectRepository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {

    @Autowired
    SubjectRepository subjectRepository;


    public SubjectDto getMySubjectToRest() {
        Subject subject = Subject.builder().name("WDI").description("Nice subject!").build();
        subjectRepository.save(subject);
        return subject.asDto();
    }

    public List<SubjectDto> getMySubjects() {
        List<SubjectDto> subjectDtos = new ArrayList<SubjectDto>();


        return subjectDtos;
    }
}
