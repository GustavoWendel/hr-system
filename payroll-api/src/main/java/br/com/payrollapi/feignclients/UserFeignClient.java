package br.com.payrollapi.feignclients;

import br.com.payrollapi.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-api", url = "http://localhost:8000")
public interface UserFeignClient {

    @GetMapping("/api/v1/users/{id}")
    ResponseEntity<User> findById(@PathVariable Long id);

    @GetMapping("/api/v1/users")
    ResponseEntity<List<User>> findAll();

}
