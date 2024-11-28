package ma.ocp.Dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data@AllArgsConstructor
@NoArgsConstructor
public class User_DTO {
    private Long id;
    private String username;
    private String token;
}
