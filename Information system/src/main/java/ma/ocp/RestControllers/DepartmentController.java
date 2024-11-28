package ma.ocp.RestControllers;
import ma.ocp.Dtos.CommercialDivisionDto;
import ma.ocp.Dtos.DepartmentDivisionDto;
import ma.ocp.Entities.Human_resourses.Department;
import ma.ocp.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @CrossOrigin("*")
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/all")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartment(id)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDepartment(@PathVariable Long id) {
        Optional<Department> departement = departmentService.getDepartment(id);
        try{
            departmentService.removeDepartment(departement.get());
            return ResponseEntity.ok("Department removed successfully");
        }
        catch(Exception e){
          return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found ");
        }
    }
    @GetMapping("/{id}/employees")
    public ResponseEntity getDepartmentEmployees(@PathVariable Long id) {
        Optional<Department> department = departmentService.getDepartment(id);
        try {
            return ResponseEntity.ok(departmentService.getDepartmentEmployees(department.get()));
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/Save")
    public ResponseEntity<Department> createDepartment(@RequestBody DepartmentDivisionDto departmentDTO) {
        return ResponseEntity.ok(departmentService.saveDepartment(Department.builder()
                .name(departmentDTO.getName()).build()));
    }


    @PutMapping(value= "/Update/{id}")
    public ResponseEntity UpdateDepartmentDivision(@RequestBody DepartmentDivisionDto departmentDivisionDto, @PathVariable Long id) {
        try{
            departmentService.update(departmentDivisionDto,id);
            return ResponseEntity.ok("Updated Successfully");
        }
        catch(Exception e) {
            return ResponseEntity.ok("Element not found");
        }
    }

}
