package pl.konradklimczak.openstudies.data.Subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
