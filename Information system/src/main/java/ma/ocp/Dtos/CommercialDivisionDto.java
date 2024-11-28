package ma.ocp.Dtos;

import jakarta.persistence.ElementCollection;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder @Data
public class CommercialDivisionDto {
    private String salesStrategy;
    private List<String> customerRelations;
    private String name;
    private String location;

}
