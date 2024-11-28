package ma.ocp.services;


import ma.ocp.Entities.Human_resourses.Student;
import ma.ocp.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Component
@Transactional
public class StudentServices {
    @Autowired
    private StudentRepository sudentrepo;

    public List<Student> getAllStudents(){
        return this.sudentrepo.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return this.sudentrepo.findById(id);
    }

    public void saveStudent(Student student) {
        this.sudentrepo.save(student);
    }

    public void removeStudent(Student student) {
        sudentrepo.delete(student);
    }

    public void removeStudentById(Long id) {
        sudentrepo.deleteById(id);
    }


}
