package ma.ocp.services;

import ma.ocp.Entities.Human_resourses.Task;
import ma.ocp.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service @Transactional
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public void removeTask(Task task) {
        taskRepository.delete(task);
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }
}
