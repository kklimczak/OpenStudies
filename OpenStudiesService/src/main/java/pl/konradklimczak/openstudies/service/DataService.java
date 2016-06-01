package pl.konradklimczak.openstudies.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import pl.konradklimczak.openstudies.data.Subject.Subject;
import pl.konradklimczak.openstudies.data.Subject.SubjectDto;
import pl.konradklimczak.openstudies.data.Subject.SubjectRepository;
import pl.konradklimczak.openstudies.utils.ExceptionsHandler.Exceptions.ElementDoesNotExist;

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

    public SubjectDto getSubjectById(Long id) throws ElementDoesNotExist {
        try {
            SubjectDto subjectDto = subjectRepository.findOne(id).asDto();
            logger.info("getSubjectById with id: {}", id);
            return subjectDto;
        } catch (NullPointerException e) {
            throw new ElementDoesNotExist("Element with id " + id + " doesn't exist!");
        }
    }

    public SubjectDto createOrUpdateSubject(SubjectDto subjectDto) {
        Subject subject = subjectRepository.save(Subject.builder().id(subjectDto.getId()).name(subjectDto.getName()).description(subjectDto.getDescription()).build());
        logger.info("createOrUpdateSubject with id: {}", subject.getId());
        return subject.asDto();
    }

    public void deleteSubjectById(Long id) throws ElementDoesNotExist {
        try {
            subjectRepository.delete(id);
            logger.info("deleteSubjectById with id: {}", id);
        } catch (EmptyResultDataAccessException e) {
            throw new ElementDoesNotExist("Element with id " + id + " doesn't exist!");
        }
    }


}
