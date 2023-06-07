package peakosft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import peakosft.dto.AuthenticationResponse;
import peakosft.dto.SignInRequest;
import peakosft.dto.SignUpRequest;
import peakosft.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationApi {

    private final AuthenticationService authenticationService;

    @PostMapping("/signUp")
    AuthenticationResponse signUp(@RequestBody SignUpRequest signUpRequest){
      return authenticationService.signUp(signUpRequest);
    }

    @PostMapping("/signIn")
    AuthenticationResponse signIn(@RequestBody SignInRequest signInRequest){
        return authenticationService.signIn(signInRequest);
    }


}
