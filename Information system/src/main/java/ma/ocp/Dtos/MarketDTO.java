package ma.ocp.Dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import ma.ocp.Entities.OperationalSystem.CommercialDivision;
@Data
@Builder
public class MarketDTO {
    private long commercial_division_id;
    private String name;
    private String location;
    private String targetCustomers;
}
