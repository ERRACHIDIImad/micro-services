package ma.ocp.Entities.resources;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import ma.ocp.Entities.OperationalSystem.IndustrialDivision;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor @Builder
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "industrial_division_id")
    private IndustrialDivision industrialDivision;

    private String name;
    private String location;
    private int capacity;

}
