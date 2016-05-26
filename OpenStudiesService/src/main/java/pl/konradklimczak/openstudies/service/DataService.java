package pl.konradklimczak.openstudies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.konradklimczak.openstudies.data.Subject.Subject;
import pl.konradklimczak.openstudies.data.Subject.SubjectDto;
import pl.konradklimczak.openstudies.data.Subject.SubjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class DataService {

    @Autowired
    private SubjectRepository subjectRepository;


    public SubjectDto getMySubjectToRest() {
        Subject subject = Subject.builder().name("WDI").description("Nice subject!").build();
        subjectRepository.save(subject);
        return subject.asDto();
    }

    public List<SubjectDto> getMySubjects() {

        List<Subject> subjects = subjectRepository.findAll();

        List<SubjectDto> subjectDtos = new ArrayList<>();

        for (Subject subject : subjects) {
            subjectDtos.add(subject.asDto());
        }

        return subjectDtos;
    }
}
