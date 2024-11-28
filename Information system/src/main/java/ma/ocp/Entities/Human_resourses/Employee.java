package ma.ocp.Entities.Human_resourses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data @Getter
@Builder
@AllArgsConstructor @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String position;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany(mappedBy = "employees", cascade=CascadeType.ALL)
    private Set<Project> projects = new HashSet<>();

    @OneToMany(mappedBy = "employee", cascade=CascadeType.ALL)
    private Set<Task> tasks = new HashSet<>();

    @OneToMany(mappedBy = "employee", cascade=CascadeType.ALL )
    private Set<Timesheet> timesheets = new HashSet<>();
}
