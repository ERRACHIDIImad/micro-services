package ma.ocp.Security.repositories;

import ma.ocp.Security.entities.appUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<appUser, Long> {
   public appUser findByUsername(String username);
}
