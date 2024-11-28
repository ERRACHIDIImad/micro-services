package ma.ocp.services;


import ma.ocp.Dtos.Project_DTO;
import ma.ocp.Entities.Human_resourses.Employee;
import ma.ocp.Entities.Human_resourses.Project;
import ma.ocp.Repositories.EmployeeRepository;
import ma.ocp.Repositories.ProjectRepository;
import ma.ocp.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service @Component @Transactional
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TaskRepository taskRepository;



    public Optional<Project> getProject(Long id) {
        return projectRepository.findById(id);
    }


    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Set<Employee> getProjectEmployees(Project project){
        return employeeRepository.findByProjectsContaining(project);
    }

    public void removeProject(Project project) {
        taskRepository.deleteByProject(project);
        employeeRepository.deleteByProject(project.getId());
        projectRepository.delete(project);
    }


    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public Project Update(Project_DTO projectdto) throws Exception{
        if(projectRepository.existsById(projectdto.getId()))
        {
         return projectRepository.save(Project.builder()
                 .endDate(projectdto.getEndDate())
                 .projectName(projectdto.getProjectName())
                 .startDate(projectdto.getStartDate())
                 .id(projectdto.getId())
                 .build());
        }
        else { throw new Exception();}

    }





}
