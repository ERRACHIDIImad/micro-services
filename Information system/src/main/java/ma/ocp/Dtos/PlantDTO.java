package ma.ocp.Dtos;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import ma.ocp.Entities.OperationalSystem.IndustrialDivision;
@Data
@Builder
public class PlantDTO {

    private long industrial_division_id;
    private String name;
    private String location;
    private int capacity;
}
