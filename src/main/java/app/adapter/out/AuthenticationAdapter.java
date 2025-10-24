package app.adapter.out;

import app.domain.model.auth.AuthCredentials;
import app.domain.model.auth.TokenResponse;

public interface AuthenticationAdapter {
    TokenResponse authenticate(AuthCredentials credentials, String role);
    boolean validateToken(String token);
    String extractUsername(String token);
    String extractRole(String token);
}