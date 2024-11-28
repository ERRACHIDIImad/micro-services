package ma.ocp.RestControllers;

import jakarta.validation.Valid;
import ma.ocp.Dtos.PaymentDto;
import ma.ocp.Dtos.PaymentStatusBody;
import ma.ocp.Entities.Human_resourses.Payment;
import ma.ocp.Entities.Human_resourses.PaymentStatus;
import ma.ocp.Entities.Human_resourses.PaymentType;
import ma.ocp.Entities.Human_resourses.Student;
import ma.ocp.Repositories.PaymentRepository;
import ma.ocp.Repositories.StudentRepository;
import ma.ocp.services.Servicesinterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController @CrossOrigin("*") @Transactional
public class StudentController{
    private StudentRepository sr;
    private PaymentRepository pr;

    private Servicesinterface s;


    public StudentController(StudentRepository s, PaymentRepository p, Servicesinterface c){
        this.pr= p ;
        this.sr= s ;
        this.s = c;
    }

    @GetMapping("/user/Students")
    public List<Student> getAllStudents(){
        return this.sr.findAll();
    }
    @GetMapping("/user/Payments")
    public List<Payment> getAllPayments(){
        return this.pr.findAll();
    }

    @GetMapping("/user/Payment/{Id}")
    public Payment paymentById(@PathVariable Long Id){
        return this.pr.findById(Id).get();
    }

    @GetMapping("/user/Student/{code}")
    public Student StdtBycode(@PathVariable String code){
        return this.sr.findByCode(code);
    }

    @GetMapping("/user/Students/progId")
    public List<Student> getAllStudentsByProgId(@PathVariable String progId){
        return this.sr.findByProgramId(progId);
    }

    @GetMapping("/user/Student/{code}/Payments")
    public List<Payment> paymentByStudentCode(@PathVariable String code){
        return this.pr.findByStudentCode(code);
    }

    @GetMapping("/user/PaymentsByStatus")
    public List<Payment>  paymentByStatus(@RequestParam PaymentStatus status){
        return this.pr.findByStatus(status);
    }

    @GetMapping("/user/PaymentsByType")
    public List<Payment>  paymentByType(@RequestParam PaymentType type){
        return this.pr.findByType(type);
    }

    @PutMapping("/admin/updatePaymentstatus")
    public void updatePaymentStatus(@RequestBody PaymentStatusBody ps){
        Payment payment = this.pr.findById(ps.getId()).get();
        payment.setStatus(ps.getStatus());
        this.pr.save(payment);
    }

    @PostMapping("/Save")
    public ResponseEntity<Student> saveStudent(@Valid Student student) {
       return ResponseEntity.ok(sr.save(student));
    }


    @PutMapping("/admin/UpdatePaymentAmount")
    public void updatePaymentAmount(@RequestParam Long PaymentId, double Amount) {
        Payment payment = this.pr.findById(PaymentId).get();
        payment.setAmount(Amount);
        this.pr.save(payment);
    }

    @PostMapping(path="/admin/SavePayment",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public void savePayment(@RequestParam MultipartFile file, PaymentDto paymentdto) throws IOException {
        this.s.savePayment(file, paymentdto);
    }

















}
