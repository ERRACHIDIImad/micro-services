package ma.fsts.cafeproject.JWT;

import lombok.extern.slf4j.Slf4j;
import ma.fsts.cafeproject.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;


@Service
@Slf4j
public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    UserDao userdao;
    private ma.fsts.cafeproject.Model.User userdetails;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Inside loadUserByName {}", username);
        userdetails  = userdao.findByEmailId(username);
        if(!Objects.isNull(userdetails))
        return new User(userdetails.getEmail(),userdetails.getPassword(),new ArrayList<>());
        else throw new  UsernameNotFoundException("User not found");
    }


        public  ma.fsts.cafeproject.Model.User getUserdetails(){
        return  this.userdetails;
    }

}
