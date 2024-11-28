package ma.ocp.Repositories;

import ma.ocp.Entities.Human_resourses.Employee;
import ma.ocp.Entities.Human_resourses.Project;
import ma.ocp.Entities.Human_resourses.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TaskRepository extends JpaRepository<Task, Long> {
    public Set<Task> findByEmployee(Employee employee);
    public  void deleteByEmployee(Employee employee);
    public  void deleteByProject(Project project);
}

