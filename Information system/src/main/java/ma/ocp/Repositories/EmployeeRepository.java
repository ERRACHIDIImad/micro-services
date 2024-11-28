package ma.ocp.Repositories;

import ma.ocp.Entities.Human_resourses.Department;
import ma.ocp.Entities.Human_resourses.Employee;
import ma.ocp.Entities.Human_resourses.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public List<Employee> findByDepartment(Department departement);
    public void deleteByDepartment_Id(Long id);
    @Query("select P from Project P inner join P.employees EP where EP.id=:id")
    public Set<Project> findEmployeeProjects(@Param("id") Long Id_employee);

    public Set<Employee> findByProjectsContaining(Project project);

    @Modifying
    @Query(value="delete from project_employees where project_id=:id" , nativeQuery = true)
    public void deleteByProject(@Param("id") Long id);
}

