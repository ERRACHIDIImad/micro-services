package ma.ocp.Security;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Controller
public class SecurityController {

    @GetMapping("/notAuthorized")
    public String NotAuthorized(Model md){
        return "redirect:/user/index?access=fail";
    }

    @GetMapping("/costumLoginPageUrl")
    public String login() {
        return "login";
    }}
