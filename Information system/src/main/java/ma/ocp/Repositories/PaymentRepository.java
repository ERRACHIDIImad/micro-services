package ma.ocp.Repositories;

import ma.ocp.Entities.Human_resourses.Payment;
import ma.ocp.Entities.Human_resourses.PaymentStatus;
import ma.ocp.Entities.Human_resourses.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    List<Payment> findByStudentCode(String Code);
    List<Payment> findByType(PaymentType type);
    List<Payment> findByStatus(PaymentStatus status);
    List<Payment> findByStudentId(Long Id);
}
