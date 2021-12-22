package micronaut.security;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/security")
public class ServiceController {

    @Get
    HttpResponse getSecurityGreetings(){
        return HttpResponse.ok("Greetings from Security!!!");
    }
}
