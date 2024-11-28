package ma.ocp.Dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Builder
@Data
public class Project_DTO {
    private Long id;
    private String projectName;
    private LocalDate startDate;
    private LocalDate endDate;
}
