package ma.ocp.Security.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity @Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class appRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String rolename ;
}
