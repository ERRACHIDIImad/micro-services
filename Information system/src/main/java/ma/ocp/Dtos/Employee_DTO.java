package ma.ocp.Dtos;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import ma.ocp.Entities.Human_resourses.Department;
@Data @Builder
public class Employee_DTO {
    private Long id;
    private String name;
    private String position;
    private Long department_id;

}
