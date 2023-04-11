package br.com.userapi.resources.impl;

import br.com.userapi.domain.User;
import br.com.userapi.resources.UserResources;
import br.com.userapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/users")
public class UserResourcesImpl implements UserResources {

    private final UserService userService;

    @Override
    public ResponseEntity<User> findById(Long id) {
        return ok().body(userService.findById(id));
    }

    @Override
    public ResponseEntity<List<User>> findAll() {
        return ok().body(userService.findAll());
    }
}
