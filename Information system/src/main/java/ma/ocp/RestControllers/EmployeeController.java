package ma.ocp.RestControllers;


import ma.ocp.Dtos.Employee_DTO;
import ma.ocp.Entities.Human_resourses.Employee;
import ma.ocp.Entities.Human_resourses.Project;
import ma.ocp.Entities.Human_resourses.Task;
import ma.ocp.Entities.Human_resourses.Timesheet;
import ma.ocp.Repositories.DepartmentRepository;
import ma.ocp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController @CrossOrigin("*")
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.removeEmployee(employeeService.getEmployee(id).get());
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/Save")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee_DTO employeeDTO) {
        Employee emp =  Employee.builder().position(employeeDTO.getPosition()).name(employeeDTO.getName()).department( departmentRepository.findById(employeeDTO.getDepartment_id()).get()).build();
        return ResponseEntity.ok(employeeService.saveEmployee(emp));
    }


    @PutMapping(value= "/Update")
    public ResponseEntity UpdateEmployee(@RequestBody Employee_DTO EmployeeDto) throws Exception {
        try {
            employeeService.update(EmployeeDto);
            return ResponseEntity.ok("Updated Successfully");
        } catch (Exception e) {
            return ResponseEntity.ok("Element not found");
        }


    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id).map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/timesheets")
    public Set<Timesheet> getEmployeeTimesheets(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployee(id);
        return employeeService.getEmployeeTimeSheets(employee.get());
    }

    @GetMapping("/{id}/projects")
    public Set<Project> getEmployeeProjects(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployee(id);
        return employeeService.getEmployeeProjects(employee.get());
    }

    @GetMapping("/{id}/tasks")
    public Set<Task> getEmployeeTasks(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployee(id);
        return employeeService.getEmployeeTasks(employee.get());
    }




    }

