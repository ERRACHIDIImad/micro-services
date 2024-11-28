package ma.ocp.RestControllers;

import ma.ocp.Dtos.TimeSheetDto;
import ma.ocp.Entities.Human_resourses.Timesheet;
import ma.ocp.Repositories.EmployeeRepository;
import ma.ocp.services.TimesheetService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @CrossOrigin("*")
@RequestMapping("/timesheets")
public class TimesheetController {
    @Autowired
    private TimesheetService timesheetService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/all")
    public List<Timesheet> getAllTimesheets() {
        return timesheetService.getAllTimesheets();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Timesheet> getTimesheetById(@PathVariable Long id) {
        Optional<Timesheet> timesheet = timesheetService.getTimeSheet(id);
        return timesheet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTimeSheet(@PathVariable Long id){
        timesheetService.removeTimeSheet(timesheetService.getTimeSheet(id).get());

    }
    @PostMapping
    public ResponseEntity<Timesheet> createTimesheet(@RequestBody TimeSheetDto timesheetddto) {
        return ResponseEntity.ok(timesheetService.saveTimesheet(Timesheet.builder()
                .date(timesheetddto.getDate())
                .hoursWorked(timesheetddto.getHoursWorked())
                .employee(employeeRepository.findById(timesheetddto.getEmployee_id()).get())
                .build()));
    }


}
