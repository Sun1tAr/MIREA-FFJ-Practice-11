package my.learn.mireaffjpractice11.controller;

import my.learn.mireaffjpractice11.DTO.response.ServerStatusResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface HealthController {

    @GetMapping("/health")
    default ResponseEntity<ServerStatusResponse> health() {
        return ResponseEntity.ok().body(new ServerStatusResponse("ok"));
    }

}
