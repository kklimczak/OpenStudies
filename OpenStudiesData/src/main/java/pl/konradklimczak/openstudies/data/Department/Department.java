package pl.konradklimczak.openstudies.data.Department;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department implements Serializable {

    private static final long serialVersionUID = 3669365744759223212L;

    private Long id;
    private String name;
    private String shortName;
    private String description;

    public DepartmentDto asDto() {
        return DepartmentDto.builder().id(id).name(name).shortName(shortName).description(description).build();
    }

}
