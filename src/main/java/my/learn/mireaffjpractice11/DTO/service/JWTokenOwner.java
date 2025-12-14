package my.learn.mireaffjpractice11.DTO.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class JWTokenOwner {

    private final Long userId;
    private final String username;

}
