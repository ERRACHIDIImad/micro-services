package ma.ocp.Security.services;
import ma.ocp.Security.entities.appRole;
import ma.ocp.Security.entities.appUser;

import java.util.Collection;

public interface userRoleInterface {
    public void addUser(String username,String email,  String password, String ConfirmPassword);
    public void addRole(appRole role);
    public void addRoleToUser(String UserName, String rolename);
    public void DeleteRoleFromUser(String UserName, String rolename);

    public Collection<appUser>   getAllUsers();
    public Collection<appRole> getAllRoles();

    public appUser getUser(String username);

    public Collection<appRole> getRolesByUser(String Username) ;
    public Collection<appUser> getUsersByRole(String role);

}
