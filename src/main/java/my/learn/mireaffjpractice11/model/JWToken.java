package my.learn.mireaffjpractice11.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class JWToken {

    private String token;
    private TokenType tokenType;
    private Date issuedAt;
    private Date expiresAt;

}
