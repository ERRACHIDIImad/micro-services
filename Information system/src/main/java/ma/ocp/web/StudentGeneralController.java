package ma.ocp.web;
import jakarta.validation.Valid;
import ma.ocp.Dtos.PaymentDto;
import ma.ocp.Entities.Human_resourses.Payment;
import ma.ocp.Entities.Human_resourses.Student;
import ma.ocp.Repositories.PaymentRepository;
import ma.ocp.Repositories.StudentRepository;
import ma.ocp.services.Servicesinterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@CrossOrigin("*")
public class StudentGeneralController {

    private StudentRepository studentDao;
    private PaymentRepository paymentDao;

    private Servicesinterface c ;

    @Autowired(required = false)
    private Page<Student> StuedentsPage;
    private Page<Payment> PaymentsPage;
    @Autowired
    private WebApplicationContext webApplicationContext;

    public StudentGeneralController(StudentRepository s, PaymentRepository p ,Servicesinterface c ) {
        this.studentDao = s;
        this.paymentDao = p;
        this.c=c;

    }
    @GetMapping(path = "/user/index")
    public String students(@RequestParam(defaultValue = "0") int PageNumber, @RequestParam(defaultValue = "0") int PaymentsPageNumber,
                           @RequestParam(defaultValue = "") String keyword, Model md, @RequestParam(defaultValue="") String access) {

        StuedentsPage = this.studentDao.findPageOfStudentsByFirstNameContains(keyword, PageRequest.of(PageNumber, 5));
        List<Student> students = StuedentsPage.getContent();
        int totalPages = StuedentsPage.getTotalPages();
        md.addAttribute("studentsList", students);
        md.addAttribute("totalPages", new int[totalPages]);
        md.addAttribute("currentPage", PageNumber);
        md.addAttribute("key", keyword);
        //------------------------------------------
        PaymentsPage = paymentDao.findAll(PageRequest.of(PaymentsPageNumber, 5));
        md.addAttribute("paiements", PaymentsPage.getContent());
        md.addAttribute("PaymentsTotalPages", new int[PaymentsPage.getTotalPages()]);
        md.addAttribute("PageNumber", PaymentsPageNumber);
        if(access.equals("fail"))
            md.addAttribute("notAuthorized", "Accès non autorisé");
        return "students";
    }

    @GetMapping("/")
    public String Home() {
        return "redirect:/user/index";
    }

    @Transactional
    @GetMapping("/admin/deleteStudent")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteStudent(@RequestParam Long Id,  String key,  int number) {
        paymentDao.deleteAll(paymentDao.findByStudentId(Id));
        studentDao.deleteById(Id);
        return "redirect:/user/index?keyword=" + key + "&PageNumber=" + number;
    }

    @GetMapping("/user/StudentsByName")
    public String studentsByName(@RequestParam String keyword, Model model) {
        model.addAttribute("studentsList", this.studentDao.findStudentsByFirstName(keyword));
        return "students";
    }

    @GetMapping("/user/StudentsByName/{Name}")
    public String getStudent(@PathVariable String Name, Model model) {
        model.addAttribute("studentsList", studentDao.findStudentsByFirstName(Name));
        return "students";
    }

    @GetMapping("/admin/addStudent")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addStudent( Model model){
        model.addAttribute("student",new Student());
        return "StudentForm";
    }

    @GetMapping("/admin/addPayment")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addPayment(){
        return "paymentForm";
    }


    @PostMapping("/admin/Save")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String saveStudent(@Valid  Student student,BindingResult br , Model md ) {
        if(br.hasErrors()) {
            md.addAttribute("message", "Data not saved!!");
            return "StudentForm";
        }
        studentDao.save(student);
        md.addAttribute("student",new Student());
        md.addAttribute("message", "Saved");
        return "StudentForm";
    }

    @GetMapping("/admin/UpdateForm")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String UpdateForm(@RequestParam long Id,Model model,@RequestParam String key,int number ){
        model.addAttribute("student",studentDao.findById(Id).get());
        model.addAttribute("key",key);
        model.addAttribute("number",number);
        return "updateForm";
    }


    @PostMapping("/admin/Update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateStudent(@Valid  Student student,BindingResult br , Model md ,@RequestParam String key,@RequestParam  int number) {
        if(br.hasErrors()) {
            md.addAttribute("message", "Data not updated!!");
            md.addAttribute("key",key);
            md.addAttribute("number",number);
            return "UpdateForm";
        }
        studentDao.save(student);
        return "redirect:/user/index?keyword="+key+"&PageNumber="+number;
    }


}








