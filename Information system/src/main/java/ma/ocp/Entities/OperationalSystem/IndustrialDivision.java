package ma.ocp.Entities.OperationalSystem;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ma.ocp.Entities.resources.Plant;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("Industry")
public class IndustrialDivision extends Division {
    private String qualityControl;
    private String processImprovements;
    @OneToMany(mappedBy = "industrialDivision", cascade=CascadeType.ALL)
    private Set<Plant> plants = new HashSet<>();
}
