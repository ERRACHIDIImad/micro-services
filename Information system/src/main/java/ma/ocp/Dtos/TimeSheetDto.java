package ma.ocp.Dtos;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import ma.ocp.Entities.Human_resourses.Employee;

import java.time.LocalDate;
@Data @Builder
public class TimeSheetDto {
    private Long id;
    private LocalDate date;
    private int hoursWorked;
    private long employee_id;
}
