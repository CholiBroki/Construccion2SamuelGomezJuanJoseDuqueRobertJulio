package app.domain.service;

import app.domain.model.User;
import app.domain.model.auth.AuthCredentials;
import app.domain.model.auth.TokenResponse;
import app.adapter.out.AuthenticationAdapter;
import app.application.exceptions.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationAdapter authenticationPort;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public TokenResponse authenticate(AuthCredentials credentials) throws Exception {
        System.out.println("🔐 Iniciando autenticación para: " + credentials.getUsername());
        
        // Buscar usuario por username
        Optional<User> userOpt = userService.findByUsername(credentials.getUsername());
        
        if (userOpt.isEmpty()) {
            System.err.println("❌ Usuario no encontrado: " + credentials.getUsername());
            throw new BusinessException("Usuario no encontrado");
        }
        
        User user = userOpt.get();
        System.out.println("✅ Usuario encontrado: " + user.getUsername());
        System.out.println("   Role: " + user.getRole());
        System.out.println("   Password en BD (primeros 20 chars): " + user.getPassword().substring(0, 20) + "...");
        
        // Validar contraseña
        boolean passwordMatches = passwordEncoder.matches(credentials.getPassword(), user.getPassword());
        System.out.println("   Contraseña ingresada: " + credentials.getPassword());
        System.out.println("   ¿Contraseña válida?: " + passwordMatches);
        
        if (!passwordMatches) {
            System.err.println("❌ Contraseña incorrecta para: " + credentials.getUsername());
            throw new BusinessException("Contraseña incorrecta");
        }
        
        // Generar token con el rol del usuario
        System.out.println("🎫 Generando token para: " + user.getUsername() + " con rol: " + user.getRole().name());
        TokenResponse response = authenticationPort.authenticate(credentials, user.getRole().name());
        System.out.println("✅ Token generado exitosamente");
        
        return response;
    }
}
