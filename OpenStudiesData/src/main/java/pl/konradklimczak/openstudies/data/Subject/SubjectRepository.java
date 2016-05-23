package pl.konradklimczak.openstudies.data.Subject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Repository
@Transactional
public interface SubjectRepository extends CrudRepository<Subject, String> {
    public Subject findByName(String name);
}
