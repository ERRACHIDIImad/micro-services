package ma.ocp.services;

import ma.ocp.Dtos.Employee_DTO;
import ma.ocp.Entities.Human_resourses.*;
import ma.ocp.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Component
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TimesheetRepository TimeSheetRepository;
    @Autowired
    private TimesheetRepository timesheetRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional
    public Optional<Employee> getEmployee(Long id) {
        return this.employeeRepository.findById(id);
    }

    public Set<Task> getEmployeeTasks(Employee employee) {
        return this.taskRepository.findByEmployee(employee);
    }

    public Set<Timesheet> getEmployeeTimeSheets(Employee employee) {
        return this.TimeSheetRepository.findByEmployee(employee);

    }

    public Set<Project> getEmployeeProjects(Employee employee) {
//        return this.projectRepository.findByEmployeesContaining(employee);
        return this.employeeRepository.findEmployeeProjects(employee.getId());
    }

    public void removeEmployee (Employee employee){
        taskRepository.deleteByEmployee(employee);
        timesheetRepository.deleteByEmployee(employee);
        projectRepository.deleteFromProjects(employee.getId());
        employeeRepository.delete(employee);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee update (Employee_DTO employeeDto ) throws Exception {
        if(employeeRepository.existsById(employeeDto.getId())){
           Employee employee=  this.employeeRepository.findById(employeeDto.getId()).get();
            employee.setName(employeeDto.getName());
            employee.setPosition(employeeDto.getPosition());
           return employeeRepository.save(employee);
        }
        else throw new Exception("User does not exist");
    }



    }





