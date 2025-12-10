package my.learn.mireaffjpractice11.service;

import lombok.RequiredArgsConstructor;
import my.learn.mireaffjpractice11.config.JwtConfig;
import my.learn.mireaffjpractice11.entity.User;
import my.learn.mireaffjpractice11.exception.JWTException;
import my.learn.mireaffjpractice11.model.JWToken;
import my.learn.mireaffjpractice11.model.TokenType;
import my.learn.mireaffjpractice11.util.JwtUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class JWTService {

    private final JwtConfig jwtConfig;
    private final RedisTemplate<Long, String> redisTemplate;
    private final JwtUtils  jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;



    public JWToken generateAccessToken(UserDetails userDetails) {
        Date issuedAt = new Date();
        Date expiresAt = new Date(
                issuedAt.getTime() + jwtConfig.getAccessTokenLifetime().toMillis()
        );
        TokenType type = TokenType.ACCESS;
        String payload = jwtUtils.generateToken(userDetails, issuedAt, expiresAt, type);
        return JWToken.builder()
                .payload(payload)
                .issuedAt(issuedAt)
                .expiresAt(expiresAt)
                .tokenType(type)
                .build();
    }

    public JWToken generateAndSaveRefreshToken(UserDetails userDetails) {
        Date issuedAt = new Date();
        Date expiresAt = new Date(
                issuedAt.getTime() + jwtConfig.getRefreshTokenLifetime().toMillis()
        );
        TokenType type = TokenType.REFRESH;
        String payload = jwtUtils.generateToken(userDetails, issuedAt, expiresAt, type);
        JWToken token = JWToken.builder()
                .payload(payload)
                .issuedAt(issuedAt)
                .expiresAt(expiresAt)
                .tokenType(type)
                .build();
        saveRefreshToken(payload);
        return token;
    }

    private void saveRefreshToken(String payload) {
        User user = (User) userService.loadUserByUsername(jwtUtils.getUsernameFromToken(payload));
        redisTemplate.opsForValue().set(user.getId(), payload);
    }

    public boolean isValidToken(String payload) {
        TokenType type;
        try {
            type = jwtUtils.getTokenTypeFromToken(payload);
        } catch (JWTException e) {
            return false;
        }

        if (type == TokenType.ACCESS) {
            return true;
        }

        User user = (User) userService.loadUserByUsername(jwtUtils.getUsernameFromToken(payload));
        String fromCache = redisTemplate.opsForValue().get(user.getId());

        if  (fromCache == null) {
            return false;
        }

        String input = passwordEncoder.encode(payload);

        return fromCache.equals(input);
    }





}
