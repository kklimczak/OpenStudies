package pl.konradklimczak.openstudies.data.Subject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDetailDto implements Serializable {

    private static final long serialVersionUID = 8386194299561133154L;

    private Long id;
    private Long subjectId;
    private String description;
}
