package micronaut.security.session;

import edu.umd.cs.findbugs.annotations.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;
import io.micronaut.session.Session;
import io.micronaut.session.SessionStore;
import io.micronaut.session.http.SessionForRequest;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class SessionAuthProvider implements AuthenticationProvider {

    @Inject
    SessionStore sessionStore;

    @Override
    public Publisher<AuthenticationResponse> authenticate(@Nullable HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        return Flowable.create(flowableEmitter -> {
            if(authenticationRequest.getIdentity().equals("sumitoma") &&
                authenticationRequest.getSecret().equals("tomar")){
                UserDetails userDetails = new UserDetails((String) authenticationRequest.getIdentity(),
                        List.of());
//                Optional<Session> session = SessionForRequest.find(httpRequest);
//                if(!session.isPresent()){
//                    Session ses = SessionForRequest.create(sessionStore, httpRequest);
//                }
//                System.out.println("Session info: "+ session.get().getId());
                flowableEmitter.onNext(userDetails);

            } else {
                flowableEmitter.onError(new AuthenticationException(new AuthenticationFailed()));
            }
            flowableEmitter.onComplete();
        }, BackpressureStrategy.ERROR);
    }
}
