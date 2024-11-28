package ma.ocp.Repositories;

import ma.ocp.Entities.Human_resourses.Employee;
import ma.ocp.Entities.Human_resourses.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    public  Set<Project> findByEmployeesContaining(Employee employee);
    @Modifying
    @Query(value = "DELETE FROM project_employees WHERE employee_id = :id", nativeQuery = true)
    public void deleteFromProjects(@Param("id")Long id);
}
