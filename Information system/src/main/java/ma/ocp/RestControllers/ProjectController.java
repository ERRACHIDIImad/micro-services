package ma.ocp.RestControllers;


import ma.ocp.Dtos.Project_DTO;
import ma.ocp.Entities.Human_resourses.Employee;
import ma.ocp.Entities.Human_resourses.Project;
import ma.ocp.services.ProjectService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController @CrossOrigin("*")
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable Long id) {
        Optional<Project> project = projectService.getProject(id);
        return project.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProject(@PathVariable Long id){
        try{
            this.projectService.removeProject(this.projectService.getProject(id).get());
            return ResponseEntity.ok("Element has been deleted succeefully");
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }

    }

    @PostMapping("/Save")
    public ResponseEntity<Project> createProject(@RequestBody Project_DTO projectDTO) {
        projectDTO.getStartDate().plusDays(1);
        projectDTO.getEndDate().plusDays(1);
        return ResponseEntity.ok(projectService.saveProject(Project.builder()
                .projectName(projectDTO.getProjectName())
                .startDate(projectDTO.getStartDate())
                .endDate(projectDTO.getEndDate()).build()));
    }

    @PutMapping("/Update")
    public ResponseEntity<Project> updateProject(@RequestBody Project_DTO projectDTO) {
        try{
            return ResponseEntity.ok(projectService.Update(projectDTO));
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/{id}/employees")
    public Set<Employee> getEmployees(@PathVariable Long id){
        return this.projectService.getProjectEmployees(projectService.getProject(id).get());
    }


}
