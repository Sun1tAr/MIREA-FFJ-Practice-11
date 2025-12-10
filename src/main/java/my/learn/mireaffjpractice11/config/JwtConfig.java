package my.learn.mireaffjpractice11.config;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.time.Duration;

@Configuration
public class JwtConfig {

    @Value("${jwt.secret}")
    private String secret;

    @Getter
    @Value("${jwt.lifetime.access}")
    private Duration accessTokenLifetime;

    @Getter
    @Value("${jwt.lifetime.refresh}")
    private Duration refreshTokenLifetime;

    @Bean
    public SecretKey secretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
