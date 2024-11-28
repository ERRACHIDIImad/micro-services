package ma.ocp.services;

import ma.ocp.Dtos.CommercialDivisionDto;
import ma.ocp.Dtos.DepartmentDivisionDto;
import ma.ocp.Entities.Human_resourses.Department;
import ma.ocp.Entities.Human_resourses.Employee;
import ma.ocp.Entities.OperationalSystem.CommercialDivision;
import ma.ocp.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service @Component @Transactional
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private TimesheetRepository timesheetRepository;
    @Autowired
    private TaskRepository taskRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartment(Long id) {
        return departmentRepository.findById(id);
    }
    public List<Employee> getDepartmentEmployees(Department department) {
        return employeeRepository.findByDepartment(department);
    }

    public void removeDepartment(Department department) {
        employeeRepository.findByDepartment(department).forEach(employee -> {
            projectRepository.deleteFromProjects(employee.getId());
            timesheetRepository.deleteByEmployee(employee);
            taskRepository.deleteByEmployee(employee);
        });
       employeeRepository.deleteByDepartment_Id(department.getId());
       departmentRepository.delete(department);
    }
    public Department update (DepartmentDivisionDto departmentDivisionDto, Long id ) throws Exception {
        if (departmentRepository.existsById(id)) {
            Department d = Department.builder()
                    .id(id)
                    .name(departmentDivisionDto.getName())
                    .build();
           return departmentRepository.save(d);
        } else throw new Exception();
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }


}
