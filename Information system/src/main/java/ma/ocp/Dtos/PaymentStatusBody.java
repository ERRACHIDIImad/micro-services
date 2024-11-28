package ma.ocp.Dtos;

import lombok.Data;
import ma.ocp.Entities.Human_resourses.PaymentStatus;
@Data
public class PaymentStatusBody {
    private Long Id; ;
    private PaymentStatus status ;
}
