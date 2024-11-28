package ma.ocp.services;


import ma.ocp.Dtos.PaymentDto;
import ma.ocp.Entities.Human_resourses.Payment;
import ma.ocp.Entities.Human_resourses.Student;
import ma.ocp.Repositories.PaymentRepository;
import ma.ocp.Repositories.StudentRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Component
@Primary
public class PaymentServices implements Servicesinterface {
    private PaymentRepository paymentDao;
    private StudentRepository studentDao;
    public PaymentServices(PaymentRepository p,StudentRepository s){
        this.paymentDao=p;
        this.studentDao=s;
    }

@Override
   public byte[] getFile(Payment payment) throws IOException {
       Path p = Path.of(URI.create(payment.getFileLocation()));
       return Files.readAllBytes(p);
   }

    public Optional<Payment> getPayment(long id) {
        return paymentDao.findById(id);
    }
    public List<Payment> getAllPayments(){
        return this.paymentDao.findAll();
    }

    @Override
    public Payment savePayment(MultipartFile file , PaymentDto paymentdto) throws IOException {
        Student student = studentDao.findById(paymentdto.getStudentId()).get();


        Path Path1 = Path.of(System.getProperty("user.home"),"OCP_Directory");
        Path Path2 = Path.of(System.getProperty("user.home"),"OCP_Directory",file.getOriginalFilename());

        if(Files.notExists(Path1))
        {
            Files.createDirectory(Path1);
        }
            //This is for updating :
            Files.deleteIfExists(Path2);

        Files.copy(file.getInputStream(),Path2);

      return  paymentDao.save(Payment.builder().id(paymentdto.getId()).date(paymentdto.getDate()).amount(paymentdto.getAmount()).type(paymentdto.getType()).status(paymentdto.getStatus()).student(student).fileLocation(Path2.toUri().toString()).build());
    }


        public void removePayment(Payment payment) {
            paymentDao.delete(payment);
        }

        public void update(MultipartFile file,PaymentDto paymentDto) throws Exception{
        if(paymentDao.existsById(paymentDto.getId())){
           this.savePayment(file,paymentDto);
        }
        else throw new Exception();
        }

}
