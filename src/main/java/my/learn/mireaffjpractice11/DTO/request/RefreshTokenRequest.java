package my.learn.mireaffjpractice11.DTO.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RefreshTokenRequest {

    @NotNull
    private String refreshToken;

}
