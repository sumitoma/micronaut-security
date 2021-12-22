package micronaut.security;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;


@Controller
public class AppController {

    @Secured(SecurityRule.IS_ANONYMOUS)
    @Get("/postLogin")
    String getPostLogin(){
        return "Login Successful";
    }

    @Secured(SecurityRule.IS_ANONYMOUS)
    @Get("/postLogout")
    String getPostLogout(){
        return "Logout Successful";
    }
}
