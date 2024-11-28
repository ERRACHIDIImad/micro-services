package ma.ocp.Dtos;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import ma.ocp.Entities.OperationalSystem.MiningDivision;
@Data
@Builder
public class Mininig_DTO {
    private Long id;
    private String name;
    private String location;
    private String safetyStandards;
    private String environmentalPolicy;
    private double explorationBudget;
}
