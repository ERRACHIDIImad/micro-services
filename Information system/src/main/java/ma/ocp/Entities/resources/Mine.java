package ma.ocp.Entities.resources;


import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import ma.ocp.Entities.OperationalSystem.MiningDivision;

@Entity
@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mining_division_id")
    private MiningDivision miningDivision;

    private String name;
    private String location;
    private int capacity;

}
