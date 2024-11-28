package ma.ocp.Dtos;
import lombok.Data;
import ma.ocp.Entities.OperationalSystem.MiningDivision;

@Data
public class Mine_DTO {
    private long mining_division_id;
    private String name;
    private String location;
    private int capacity;

}
