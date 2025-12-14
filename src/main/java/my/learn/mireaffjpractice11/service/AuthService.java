package my.learn.mireaffjpractice11.service;


import my.learn.mireaffjpractice11.DTO.request.LoginUserRequest;
import my.learn.mireaffjpractice11.DTO.request.RefreshTokenRequest;
import my.learn.mireaffjpractice11.DTO.request.RegisterUserRequest;
import my.learn.mireaffjpractice11.DTO.response.AuthResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {


    AuthResponse registerUser(RegisterUserRequest req);

    AuthResponse loginUser(LoginUserRequest req);

    AuthResponse logoutUser();

    AuthResponse refreshExpiredAccessToken(RefreshTokenRequest req);

    Authentication createAuthByAccessJwt(String jwt);
}
