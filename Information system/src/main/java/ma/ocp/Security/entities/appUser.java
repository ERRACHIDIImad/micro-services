package ma.ocp.Security.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class appUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection <appRole> roles;
}
