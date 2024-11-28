package ma.ocp.services;

import ma.ocp.Entities.Human_resourses.Timesheet;
import ma.ocp.Repositories.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service @Transactional
public class TimesheetService {
    @Autowired
    private TimesheetRepository timesheetRepository;

    public List<Timesheet> getAllTimesheets() {
        return timesheetRepository.findAll();
    }

    public Optional<Timesheet> getTimeSheet(Long id) {
        return timesheetRepository.findById(id);
    }

    public void removeTimeSheet(Timesheet timeSheet) {
        timesheetRepository.delete(timeSheet);
    }

    public Timesheet saveTimesheet(Timesheet timesheet) {
        return timesheetRepository.save(timesheet);
    }
}
