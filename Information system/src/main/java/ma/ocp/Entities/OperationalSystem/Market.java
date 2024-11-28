package ma.ocp.Entities.OperationalSystem;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "commercial_division_id")
    @JsonBackReference
    private CommercialDivision commercialDivision;

    private String name;
    private String location;
    private String targetCustomers;

}
