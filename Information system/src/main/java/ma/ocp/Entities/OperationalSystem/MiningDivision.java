package ma.ocp.Entities.OperationalSystem;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@DiscriminatorValue("Mining")
public class MiningDivision extends Division {
    private String safetyStandards;
    private String environmentalPolicy;
    private double explorationBudget;

}
