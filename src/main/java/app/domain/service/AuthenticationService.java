package app.domain.service;

import app.domain.model.User;
import app.domain.model.auth.AuthCredentials;
import app.domain.model.auth.TokenResponse;
import app.adapter.out.AuthenticationAdapter;
import app.adapter.out.UserAdapter;
import app.application.exceptions.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationAdapter authenticationPort;

    @Autowired
    private UserAdapter userPort;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public TokenResponse authenticate(AuthCredentials credentials) throws Exception {
        User user = this.getUserByUsername(credentials.getUsername());
        this.validatePassword(credentials.getPassword(), user.getPassword());
        return authenticationPort.authenticate(credentials, String.valueOf(user.getRole()));
    }

    private User getUserByUsername(String username) throws Exception {
        User user = new User();
        user.setUsername(username);
        user = userPort.findByUsername(user);
        if (user == null) {
            throw new BusinessException("Usuario no encontrado");
        }
        return user;
    }

    private void validatePassword(String inputPassword, String storedPassword) throws Exception {
        if (!passwordEncoder.matches(inputPassword, storedPassword)) {
            throw new BusinessException("Contraseña incorrecta");
        }
    }
}