package app.domain.service;

import app.adapter.out.AuthenticationAdapter;
import app.adapter.out.UserAdapter;
import app.application.exceptions.BusinessException;
import app.domain.model.User;
import app.domain.model.auth.AuthCredentials;
import app.domain.model.auth.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationAdapter authenticationPort;

    @Autowired
    private UserAdapter userAdapter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public TokenResponse authenticate(AuthCredentials credentials) throws Exception {
        if (credentials == null || credentials.getUsername() == null || credentials.getPassword() == null) {
            throw new BusinessException("Las credenciales no pueden ser nulas");
        }

        System.out.println("🔍 [AuthenticationService] Buscando usuario: " + credentials.getUsername());
        Optional<User> userOpt = userAdapter.findByUsername(credentials.getUsername());

        if (userOpt.isEmpty()) {
            throw new BusinessException("Usuario no encontrado");
        }

        User user = userOpt.get();

        System.out.println("🔐 [AuthenticationService] Verificando contraseña para usuario: " + user.getUsername());
        if (!passwordEncoder.matches(credentials.getPassword(), user.getPassword())) {
            throw new BusinessException("Contraseña incorrecta");
        }

        System.out.println("✅ [AuthenticationService] Usuario autenticado correctamente, generando token...");
        return authenticationPort.authenticate(credentials, user.getRole().name());
    }
}
