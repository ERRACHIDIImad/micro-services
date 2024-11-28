package ma.ocp.Repositories;

import ma.ocp.Entities.Human_resourses.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
