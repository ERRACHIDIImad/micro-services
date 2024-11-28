package ma.ocp.Entities.Human_resourses;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity  @AllArgsConstructor @Builder @NoArgsConstructor @Setter @Getter
public class Payment {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private double amount ;
    private PaymentType type;
    private PaymentStatus status;
    private String fileLocation;
    @ManyToOne
    @JoinColumn(name = "StudentId")
    @JsonBackReference
    private Student student ;
}
