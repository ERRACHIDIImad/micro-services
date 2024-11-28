package ma.ocp.Entities.Human_resourses;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectName;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToMany
    @JoinTable(
            name = "project_employees",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private Set<Employee> employees = new HashSet<>();

    @OneToMany(mappedBy = "project", cascade=CascadeType.ALL)
    private Set<Task> tasks = new HashSet<>();

}
