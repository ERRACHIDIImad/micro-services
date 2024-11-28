package ma.ocp.Entities.Human_resourses;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity  @Builder  @AllArgsConstructor @NoArgsConstructor @Setter @Getter
public class Student {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(length = 1000)
    private Long id;


    @Column(length = 30)  @NotEmpty
    private String firstName;


    @Column(length = 30)  @Size(min=2, max=10)
    private String lastName;


    @Column(unique = true)  @Size(min=6)
    private String code;

    @Column(length = 30)
    private String photo;

    @NotEmpty
    private String programId;

    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private Set<Payment> payments = new HashSet<>();
}
