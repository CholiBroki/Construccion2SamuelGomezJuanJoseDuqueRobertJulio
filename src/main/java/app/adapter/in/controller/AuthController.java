package app.adapter.in.controller;

import app.domain.model.auth.AuthCredentials;
import app.domain.model.auth.TokenResponse;
import app.adapter.out.AuthenticationAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationAdapter authenticationAdapter;

    public AuthController(AuthenticationAdapter authenticationAdapter) {
        this.authenticationAdapter = authenticationAdapter;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody AuthCredentials credentials) {
        return ResponseEntity.ok(authenticationAdapter.authenticate(credentials, credentials.getRole()));
    }
}