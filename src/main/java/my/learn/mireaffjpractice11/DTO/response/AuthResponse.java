package my.learn.mireaffjpractice11.DTO.response;

import lombok.Builder;
import lombok.Data;
import my.learn.mireaffjpractice11.model.JWToken;

import java.util.List;

@Data
@Builder
public class AuthResponse {

    private List<JWToken> tokens;

}
