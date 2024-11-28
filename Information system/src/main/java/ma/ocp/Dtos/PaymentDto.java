package ma.ocp.Dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import ma.ocp.Entities.Human_resourses.PaymentStatus;
import ma.ocp.Entities.Human_resourses.PaymentType;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PaymentDto {
    private long id;
    private LocalDate date;
    private double amount;
    private PaymentType type;
    private PaymentStatus status;
    private Long StudentId;
}
