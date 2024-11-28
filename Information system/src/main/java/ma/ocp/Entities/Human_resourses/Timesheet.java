package ma.ocp.Entities.Human_resourses;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Timesheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private int hoursWorked;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
