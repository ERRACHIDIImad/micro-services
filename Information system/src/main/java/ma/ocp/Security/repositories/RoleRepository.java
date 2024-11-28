package ma.ocp.Security.repositories;

import ma.ocp.Security.entities.appRole;
import ma.ocp.Security.entities.appUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface RoleRepository  extends JpaRepository<appRole,Long> {
  public appRole findByRolename(String roleName);

  @Query("Select A from appUser A  join  A.roles B where B.rolename = :x")
  public Collection<appUser> getUsersByRole(@Param("x") String role) ;
}
