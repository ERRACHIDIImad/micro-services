package ma.ocp.Dtos;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import ma.ocp.Entities.Human_resourses.Employee;
import ma.ocp.Entities.Human_resourses.Project;

import java.time.LocalDate;
@Data
@Builder
public class Task_DTO {
    private String taskName;
    private String description;
    private LocalDate deadline;
    private boolean completed;
    private long project_id;
    private Long employee_id;
}
