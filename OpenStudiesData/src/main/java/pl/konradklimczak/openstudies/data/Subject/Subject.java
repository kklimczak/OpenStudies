package pl.konradklimczak.openstudies.data.Subject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    private String name;
    private String description;

    public SubjectDto asDto() {
        return SubjectDto.builder().name(name).description(description).build();
    }
}

