package ma.ocp.services;
import ma.ocp.Entities.Human_resourses.*;
import ma.ocp.Entities.OperationalSystem.CommercialDivision;
import ma.ocp.Entities.OperationalSystem.IndustrialDivision;
import ma.ocp.Entities.OperationalSystem.Market;
import ma.ocp.Entities.OperationalSystem.MiningDivision;
import ma.ocp.Entities.resources.Mine;
import ma.ocp.Entities.resources.Plant;
import ma.ocp.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;


@Service @Transactional
public class GeneralServices {

    @Autowired
    private DepartmentRepository departmentRepository;


    @Autowired
    private PaymentRepository paymentRepository;


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private StudentRepository studentrepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TimesheetRepository timesheetRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private IndustrialRepositry industrialRepositry;

    @Autowired
    private MarketRepository marketRepository;

    @Autowired
    private MineRepository mineReposirtory;

    @Autowired
    private MiningRepository miningRepository;

    @Autowired
    private CommercialRepository commercialRepository;
    public void onInint() {
        // Create and save students
       IntStream.range(1,4).forEach(index -> {

        studentrepository.save(Student.builder()
            .firstName("Firstname "+index)
            .lastName("Lastname "+index)
            .code(String.valueOf(Math.floor(Math.random()*1000000+1000)))
            .photo("Photo "+index)
            .programId("ProgramId "+index)
            .build()
           );
       });

        IntStream.range(1,31).forEach(index -> {

            paymentRepository.save(Payment.builder()
                    .amount(Math.random()*1000+1000)
                    .date(index %5==0 ? LocalDate.now().plusMonths(5) :(index %2==0 ? LocalDate.now().plusMonths(2):LocalDate.now().minusWeeks(12) ))
                    .type(index %5==0 ? PaymentType.DEPOSIT :(index %2==0 ? PaymentType.CASH:PaymentType.TRANSFERT))
                    .status(index %2==0 ? PaymentStatus.VALIDATED :(index % 3==0 ? PaymentStatus.REJECTED : PaymentStatus.CREATED))
                    .fileLocation("Location "+index)
                    .build()
            );
        });

        List<Student> students = studentrepository.findAll();
        List<Payment> payments = paymentRepository.findAll();
        payments.subList(0,10).forEach(payment->{
            payment.setStudent(students.get(0)) ;

        });

        payments.subList(10,20).forEach(payment->{
            payment.setStudent(students.get(1)) ;

        });

        payments.subList(20,30).forEach(payment->{
            payment.setStudent(students.get(2)) ;

        });


        // Create and save departments
        Department miningDepartment = Department.builder().name("Mining").build();
        Department chemicalDepartment = Department.builder().name("Chemical Processing").build();
        Department logisticsDepartment = Department.builder().name("Logistics").build();
        departmentRepository.saveAll(List.of(miningDepartment, chemicalDepartment, logisticsDepartment));

        IntStream.range(1,31).forEach(index -> {
            employeeRepository.save(
                  Employee.builder()
                          .name("Employee "+index)
                          .position("Position "+index)
                          .department(index %2==0 ? miningDepartment :(index %3==0 ?chemicalDepartment:logisticsDepartment))
                          .build()
            );
        });



//
        // Create and save projects
        Project project1 = Project.builder()
                .projectName("Mining Enhancement Project")
                .startDate(LocalDate.now().minusMonths(2))
                .endDate(LocalDate.now().plusMonths(4))
                .build();

        Project project2 = Project.builder()
                .projectName("New Chemical Plant Setup")
                .startDate(LocalDate.now().minusMonths(1))
                .endDate(LocalDate.now().plusMonths(6))
                .build();

        Project project3 = Project.builder()
                .projectName("Logistics Optimization")
                .startDate(LocalDate.now().minusDays(10))
                .endDate(LocalDate.now().plusMonths(3))
                .build();

//        // Assign employees to projects
        List<Employee> employees = employeeRepository.findAll();
        project1.setEmployees(new HashSet<>(employees.subList(0, 10)));
        project2.setEmployees(new HashSet<>(employees.subList(10, 20)));
        project3.setEmployees(new HashSet<>(employees.subList(20, 30)));
        projectRepository.saveAll(List.of(project1, project2, project3));
//
        // Create and save tasks
        IntStream.range(1, 20).forEach(i -> {
            Task task = Task.builder()
                    .taskName("Task" + i)
                    .description("Description for Task" + i)
                    .deadline(LocalDate.now().plusWeeks(i))
                    .completed(i % 2 == 0)
                    .project(i % 3 == 0 ? project1 : (i % 3 == 1 ? project2 : project3))
                    .employee(employees.get(i))
                    .build();
            taskRepository.save(task);
        });

        // Create and save timesheets
        IntStream.range(1, 100).forEach(i -> {
            Timesheet timesheet = Timesheet.builder()
                    .date(LocalDate.now().minusDays(i))
                    .hoursWorked((i % 8) + 1)
                    .employee(employees.get(i % employees.size()))
                    .build();
            timesheetRepository.save(timesheet);
        });

        IndustrialDivision division1 = (IndustrialDivision) IndustrialDivision.builder()
                .qualityControl("High")
                .processImprovements("Effeciency")
                .name("Division 1")
                .location("Location 1")
                .build();

        IndustrialDivision division2 = (IndustrialDivision) IndustrialDivision.builder()
                .qualityControl("Medium")
                .processImprovements("Innovation")
                .name("Division 2")
                .location("Location 2")
                .build();

        industrialRepositry.saveAll(List.of(division1, division2));

        // Create Plants and associate them with Industrial Divisions
        IntStream.range(1, 6).forEach(i -> {
            Plant plant = Plant.builder()
                    .name("Plant " + i)
                    .location("Plant Location " + i)
                    .capacity(1000 * i)
                    .industrialDivision(i % 2 == 0 ? division1 : division2)
                    .build();
            plantRepository.save(plant);
        });


        MiningDivision miningdivision1 = (MiningDivision) MiningDivision.builder()
                .environmentalPolicy("Policy 1")
                .explorationBudget(20000)
                .safetyStandards("Standard 1")
                .name("Division 1")
                .location("Location 1")
                .build();

        MiningDivision miningdivision2 = (MiningDivision) MiningDivision.builder()
                .environmentalPolicy("Policy 2")
                .explorationBudget(3000000)
                .safetyStandards("Standard 2")
                .name("Division 2")
                .location("Location 2")
                .build();


        MiningDivision miningdivision3 = (MiningDivision) MiningDivision.builder()
                .environmentalPolicy("Policy 3")
                .explorationBudget(400000)
                .safetyStandards("Standard 3")
                .name("Division 3")
                .location("Location 3")
                .build();

        this.miningRepository.saveAll(List.of(miningdivision1,miningdivision2,miningdivision3));

        // Create and save Mines
        IntStream.range(1, 15).forEach(i -> {
            Mine mine = Mine.builder()
                    .name("Mine " + i)
                    .location("Location " + i)
                    .capacity(500 * i)
                    .miningDivision(i % 2 == 0 ? miningdivision1 : (i % 3 == 0 ? miningdivision2 : miningdivision3))
                    .build();
            mineReposirtory.save(mine);
        });

            CommercialDivision commercialdivision1 = (CommercialDivision)CommercialDivision.builder()
                    .customerRelations(List.of("Relation 1","Relation 2", "Relation 3"))
                    .salesStrategy("Strategy 1")
                    .name("Division 1")
                    .location("location 1")
                    .build();

            CommercialDivision commercialdivision2 = (CommercialDivision)CommercialDivision.builder()
                    .customerRelations(List.of("Relation 1","Relation 2", "Relation 3"))
                    .salesStrategy("Strategy 2")
                    .name("Division 2")
                    .location("location 2")
                    .build();

            CommercialDivision commercialdivision3 = (CommercialDivision)CommercialDivision.builder()
                    .customerRelations(List.of("Relation 1","Relation 2", "Relation 3"))
                    .salesStrategy("Strategy 3")
                    .name("Division 3")
                    .location("location 3")
                    .build();
        commercialRepository.saveAll(List.of(commercialdivision1,commercialdivision2,commercialdivision3));

        List<CommercialDivision>liste = commercialRepository.findAll();

        Market market1 = Market.builder()
                .name("market 1")
                .location("location 1")
                .targetCustomers("Customer 1")
                .commercialDivision(liste.get(0))
                .build();
        Market market2 = Market.builder()
                .name("market 2")
                .location("location 2")
                .commercialDivision(liste.get(1))
                .targetCustomers("Customer 2")
                .build();
        Market market3 = Market.builder()
                .name("market 3")
                .location("Location 3")
                .targetCustomers("Customer 3")
                .commercialDivision(liste.get(2))
                .build();
        marketRepository.saveAll(List.of(market1,market2,market3));

    }
        }




