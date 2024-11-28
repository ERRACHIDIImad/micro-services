package ma.ocp.Repositories;

import ma.ocp.Entities.Human_resourses.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository <Student, Long> {
     Student        findByCode(String code);
     List<Student>  findByProgramId(String Id);
     List<Student>  findStudentsByFirstName(String FirstName);
     Page<Student>  findPageOfStudentsByFirstNameContains(String keyword,Pageable pageable);
}
