package pl.konradklimczak.openstudies.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.konradklimczak.openstudies.data.Subject.Subject;
import pl.konradklimczak.openstudies.data.Subject.SubjectDto;
import pl.konradklimczak.openstudies.data.Subject.SubjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataService {

    @Autowired
    private SubjectRepository subjectRepository;

    private Logger logger = Logger.getLogger(DataService.class);


    public List<SubjectDto> getAllSubjects() {
        List<Subject> subjects = subjectRepository.findAll();
        List<SubjectDto> subjectDtos = subjects.stream()
                .map(Subject::asDto).collect(Collectors.toList());

        logger.info("getMySubjects called");

        return subjectDtos;
    }

    public SubjectDto getSubjectById(Long id) {
        SubjectDto subjectDto = subjectRepository.findOne(id).asDto();
        logger.info("getSubjectById with id: " + id);
        return subjectDto;
    }

    public SubjectDto createOrUpdateSubject(SubjectDto subjectDto) {
        Subject subject = subjectRepository.save(Subject.builder().id(subjectDto.getId()).name(subjectDto.getName()).description(subjectDto.getDescription()).build());
        logger.info("createOrUpdateSubject with id " + subject.getId());
        return subject.asDto();
    }

    public void deleteSubjectById(Long id) {
        subjectRepository.delete(id);
        logger.info("deleteSubjectById with id: " + id);
    }




}
