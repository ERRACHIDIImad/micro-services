package ma.ocp.Security;
import ma.ocp.Security.services.UserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class  SECURITY_CONFIGURATION implements WebMvcConfigurer {
    private UserDetailsService userdetailservice ;

    public SECURITY_CONFIGURATION( UserDetailsService userdetailservice) {
        this.userdetailservice = userdetailservice;
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity httpsecurity) throws Exception {
//      httpsecurity.authorizeHttpRequests().requestMatchers("/admin/**").hasRole("ADMIN");
//      httpsecurity.authorizeHttpRequests().requestMatchers("/user/**").hasRole("USER");
        httpsecurity.authorizeHttpRequests().requestMatchers("/webjars/**").permitAll();
        httpsecurity.authorizeHttpRequests().anyRequest().authenticated();
        httpsecurity.rememberMe();
        httpsecurity.logout();
        httpsecurity.csrf().disable();
        httpsecurity.userDetailsService(userdetailservice);
        httpsecurity.formLogin(form -> form
                .loginPage("/costumLoginPageUrl")
                .permitAll()
                .defaultSuccessUrl("/")
                );
        httpsecurity.exceptionHandling().accessDeniedPage("/notAuthorized");
        return httpsecurity.build();
    }





}

