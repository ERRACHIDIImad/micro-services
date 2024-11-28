package ma.ocp.services;

import ma.ocp.Dtos.PaymentDto;
import ma.ocp.Entities.Human_resourses.Payment;
import ma.ocp.Entities.OperationalSystem.Division;
import ma.ocp.Entities.Human_resourses.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface Servicesinterface {
    public byte[] getFile(Payment payment) throws IOException;

    public Payment savePayment(MultipartFile file,PaymentDto paymentdto) throws IOException;

}
