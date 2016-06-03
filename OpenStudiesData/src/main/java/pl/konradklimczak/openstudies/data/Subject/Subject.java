package pl.konradklimczak.openstudies.data.Subject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long departmentId;
    private String name;
    private String description;

    public SubjectDto asDto() {
        return SubjectDto.builder().id(id).departmentId(departmentId).name(name).description(description).build();
    }
}

