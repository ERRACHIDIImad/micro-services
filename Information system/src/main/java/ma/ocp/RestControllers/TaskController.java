package ma.ocp.RestControllers;

import ma.ocp.Dtos.Task_DTO;
import ma.ocp.Entities.Human_resourses.Employee;
import ma.ocp.Entities.Human_resourses.Project;
import ma.ocp.Entities.Human_resourses.Task;
import ma.ocp.Repositories.EmployeeRepository;
import ma.ocp.Repositories.ProjectRepository;
import ma.ocp.Repositories.TaskRepository;
import ma.ocp.services.TaskService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @CrossOrigin("*")
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteTask(@PathVariable Long id) {
       try{
           taskService.removeTask(taskService.getTaskById(id).get());
           return ResponseEntity.ok("Task has been deleted successfully");
          }
       catch(Exception e){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Element not found");
       }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public ResponseEntity<Task> createTask(@RequestBody Task_DTO taskDTO) {
        Employee emp = employeeRepository.findById(taskDTO.getEmployee_id()).get();
        Project project = projectRepository.findById(taskDTO.getProject_id()).get();
        Task task = Task.builder().taskName(taskDTO.getTaskName()).description(taskDTO.getDescription()).deadline(taskDTO.getDeadline())
                .project(project).employee(emp).completed(taskDTO.isCompleted()).build();
        return ResponseEntity.ok(taskService.saveTask(task));
    }

}
