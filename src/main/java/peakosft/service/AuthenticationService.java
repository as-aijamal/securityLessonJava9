package peakosft.service;

import peakosft.dto.AuthenticationResponse;
import peakosft.dto.SignInRequest;
import peakosft.dto.SignUpRequest;

public interface AuthenticationService {

    AuthenticationResponse signUp(SignUpRequest signUpRequest);

    AuthenticationResponse signIn(SignInRequest signInRequest);
}
