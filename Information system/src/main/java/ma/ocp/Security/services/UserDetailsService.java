package ma.ocp.Security.services;
import lombok.AllArgsConstructor;
import ma.ocp.Security.entities.appUser;
import ma.ocp.Security.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@AllArgsConstructor @Component
public class UserDetailsService implements  org.springframework.security.core.userdetails.UserDetailsService {
    private UserRepository repo ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
           appUser appuser = this.repo.findByUsername(username);
           if(appuser == null) throw new UsernameNotFoundException("User not found !");
           String [] roles = appuser.getRoles().stream().map(role->role.getRolename()).toArray(String[]::new);

           UserDetails userDetails = User.withUsername(username)
                   .password(appuser.getPassword())
                   .roles(roles)
                   .build();
           return userDetails;
    }
}
