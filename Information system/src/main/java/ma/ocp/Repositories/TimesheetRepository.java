package ma.ocp.Repositories;

import ma.ocp.Entities.Human_resourses.Employee;
import ma.ocp.Entities.Human_resourses.Task;
import ma.ocp.Entities.Human_resourses.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {
    public Set<Timesheet> findByEmployee(Employee employee);
    public  void deleteByEmployee(Employee employee);
}
