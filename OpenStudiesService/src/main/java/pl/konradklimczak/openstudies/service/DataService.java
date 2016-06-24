package pl.konradklimczak.openstudies.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import pl.konradklimczak.openstudies.data.Subject.Subject;
import pl.konradklimczak.openstudies.data.Subject.SubjectDto;
import pl.konradklimczak.openstudies.data.Subject.SubjectRepository;
import pl.konradklimczak.openstudies.utils.ExceptionsHandler.Exceptions.NoElementException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataService {

    @Autowired
    private SubjectRepository subjectRepository;

    private Logger logger = LoggerFactory.getLogger(DataService.class);


    public List<SubjectDto> getAllSubjects() {
        List<Subject> subjects = subjectRepository.findAll();
        List<SubjectDto> subjectDtos = subjects.stream()
                .map(Subject::asDto).collect(Collectors.toList());

        logger.info("getMySubjects called");

        return subjectDtos;
    }

    public SubjectDto getSubjectById(Long id) throws NoElementException {
        Subject subject = subjectRepository.findOne(id);
        logger.info("getSubjectById with id: {}", id);
        if (subject == null) {
            throw new NoElementException("Element with id " + id + " doesn't exist!");
        }
        return subject.asDto();
    }

    public SubjectDto createOrUpdateSubject(SubjectDto subjectDto) {
        Subject subject = subjectRepository.save(Subject.builder().id(subjectDto.getId()).name(subjectDto.getName()).description(subjectDto.getDescription()).build());
        logger.info("createOrUpdateSubject with id: {}", subject.getId());
        return subject.asDto();
    }

    public void deleteSubjectById(Long id) throws NoElementException {
        try {
            subjectRepository.delete(id);
            logger.info("deleteSubjectById with id: {}", id);
        } catch (EmptyResultDataAccessException e) {
            throw new NoElementException("Element with id " + id + " doesn't exist!");
        }
    }


}
