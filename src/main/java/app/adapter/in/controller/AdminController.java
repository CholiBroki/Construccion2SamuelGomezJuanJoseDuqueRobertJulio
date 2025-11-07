package app.adapter.in.controller;

import app.application.usecase.AdminUseCase;
import app.domain.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private AdminUseCase adminUseCase;

    @PostMapping("/users/doctor")
    public ResponseEntity<User> createDoctor(@RequestBody User user) {
        User created = adminUseCase.createDoctor(user);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PostMapping("/users/seller")
    public ResponseEntity<User> createSeller(@RequestBody User user) throws Exception {
        User created = adminUseCase.createSeller(user);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
