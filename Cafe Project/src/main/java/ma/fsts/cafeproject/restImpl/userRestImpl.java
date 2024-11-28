package ma.fsts.cafeproject.restImpl;

import ma.fsts.cafeproject.Service.userService;
import ma.fsts.cafeproject.constents.Constents;
import ma.fsts.cafeproject.rest.UserRest;
import ma.fsts.cafeproject.utils.CafeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class userRestImpl implements UserRest {

    @Autowired
    userService userservice;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try {
            return userservice.signUp(requestMap);
            }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return  CafeUtils.getResponseEntity(Constents.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
