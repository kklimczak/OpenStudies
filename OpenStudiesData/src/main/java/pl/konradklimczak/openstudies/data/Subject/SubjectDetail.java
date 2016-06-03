package pl.konradklimczak.openstudies.data.Subject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDetail {

    private Long id;
    private Long subjectId;

    private String description;

    public SubjectDetailDto asDto() {
        return SubjectDetailDto.builder().id(id).subjectId(subjectId).description(description).build();
    }
}
