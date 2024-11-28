package ma.ocp.Security.services;

import lombok.AllArgsConstructor;
import ma.ocp.Security.entities.appRole;
import ma.ocp.Security.entities.appUser;
import ma.ocp.Security.repositories.RoleRepository;
import ma.ocp.Security.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;

@Component
@Service
@Transactional @AllArgsConstructor
public class UserRoleService implements userRoleInterface{

    private RoleRepository roleRepo;
    private UserRepository UserRepo;
    private PasswordEncoder passwordEncoder;

    @Override
    public void addRoleToUser(String UserName, String rolename) {
        appRole r = roleRepo.findByRolename(rolename);
        this.UserRepo.findByUsername(UserName).getRoles().add(r);
    }
    @Override
    public void DeleteRoleFromUser(String UserName, String rolename) {
        appRole r = roleRepo.findByRolename(rolename);
        this.UserRepo.findByUsername(UserName).getRoles().remove(r);
    }

    @Override
    public void addUser(String username, String email,String password, String ConfirmPassword){
        if (this.UserRepo.findByUsername(username)!=null) throw new RuntimeException("User already exists");
        if(!password.equals(ConfirmPassword)) throw new RuntimeException("Passwords don't match");
        this.UserRepo.save(new appUser(null,username,email,passwordEncoder.encode(password),null));
    }

    @Override
    public void addRole(appRole role){
        this.roleRepo.save(role);
    }

    @Override
    public Collection<appUser> getAllUsers() {
        return this.UserRepo.findAll();
    }

    @Override
    public Collection<appRole> getAllRoles() {
        return this.roleRepo.findAll();
    }

    @Override
    public appUser getUser(String username){
        return this.UserRepo.findByUsername(username);
    }

    @Override
    public Collection<appRole> getRolesByUser(String User) {
     return this.UserRepo.findByUsername(User).getRoles();
    }

    @Override
    public Collection<appUser> getUsersByRole(String role) {
       return roleRepo.getUsersByRole(role);
    }

}
