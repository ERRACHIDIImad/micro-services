package ma.ocp.Entities.OperationalSystem;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data @Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("Commerce")
public class CommercialDivision extends Division {
    private String salesStrategy;
    @ElementCollection
    private List<String> customerRelations;
    @OneToMany(mappedBy = "commercialDivision" , cascade=CascadeType.ALL)
    @JsonManagedReference
    private Set<Market> markets = new HashSet<>();
}
