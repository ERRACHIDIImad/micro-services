package ma.ocp;

import ma.ocp.Entities.Human_resourses.*;
import ma.ocp.Repositories.*;
import ma.ocp.Security.entities.appRole;
import ma.ocp.Security.services.userRoleInterface;
import ma.ocp.services.GeneralServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoProductsApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoProductsApplication.class, args);
    }

    @Bean
    CommandLineRunner  runnerUserService(userRoleInterface Ur, GeneralServices generalServices) {
        return args -> {
            Ur.addUser("imad123","imad@gmail.com","jgjhbj66666","jgjhbj66666");
            Ur.addUser("afaf.errachidi98","afaf@gmail.com","55165","55165");
            Ur.addUser("anassGogo","anass@gmail.com","165165111","165165111");

            Ur.addRole(appRole.builder().id(null).rolename("ADMIN").build());
            Ur.addRole(appRole.builder().id(null).rolename("CLIENT").build());
            Ur.addRole(appRole.builder().id(null).rolename("COMMERCE_MANAGER").build());
            Ur.addRole(appRole.builder().id(null).rolename("PRODUCTION_MANAGER").build());

            Ur.addRoleToUser("imad123","ADMIN");
            Ur.addRoleToUser("imad123","CLIENT");
            Ur.addRoleToUser("afaf.errachidi98","CLIENT");
            Ur.addRoleToUser("anassGogo","COMMERCE_MANAGER");
            generalServices.onInint();

        };
    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    }


