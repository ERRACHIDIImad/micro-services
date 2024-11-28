package ma.fsts.cafeproject.serviceImpl;


import lombok.extern.slf4j.Slf4j;
import ma.fsts.cafeproject.Model.User;
import ma.fsts.cafeproject.Service.userService;
import ma.fsts.cafeproject.constents.Constents;
import ma.fsts.cafeproject.dao.UserDao;
import ma.fsts.cafeproject.utils.CafeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;


@Slf4j
@Service
public class userServiceImpl implements userService {
    @Autowired
    UserDao userdao;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Inside signup {}", requestMap);
     try {
         if (validateSignUpMap(requestMap)) {
             User user = userdao.findByEmailId(requestMap.get("email"));
             if (Objects.isNull(user)) {
                 userdao.save(getUserFromMap(requestMap));
                 return CafeUtils.getResponseEntity("User registred successfully", HttpStatus.OK);
             } else return CafeUtils.getResponseEntity("Email already exists", HttpStatus.BAD_REQUEST);

         }
         return CafeUtils.getResponseEntity(Constents.INVALID_DATA, HttpStatus.BAD_REQUEST);
     }
          catch(Exception ex){
          ex.printStackTrace();
        }
        return CafeUtils.getResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean validateSignUpMap(Map<String,String> requestMap)
        {
       if(requestMap.containsKey("name")&&requestMap.containsKey("email")
               && requestMap.containsKey("password")&&requestMap.containsKey("contactNumber"))
           return true ;
           return false;
        }
            private User getUserFromMap(Map<String ,String> requestMap){
            User user = new User();
            user.setName(requestMap.get("name"));
            user.setContactNumber(requestMap.get("contactNumber"));
            user.setEmail(requestMap.get("email"));
            user.setPassword(requestMap.get("password"));
            user.setStatus("false");
            user.setRole("user");
            return user;
        }
    }

