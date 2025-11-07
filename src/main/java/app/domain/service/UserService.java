package app.domain.service;

import app.domain.model.User;
import app.domain.model.auth.AuthCredentials;
import app.domain.model.auth.TokenResponse;
import app.adapter.out.AuthenticationAdapter;
import app.adapter.out.UserAdapter;
import app.application.exceptions.BusinessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Servicio de dominio responsable de la autenticación de usuarios.
 */
@Service
public class UserService {

    private final AuthenticationAdapter authenticationPort;
    private final UserAdapter userAdapter;
    private final PasswordEncoder passwordEncoder;

    // ✅ Inyección por constructor (mejor práctica)
    public UserService(AuthenticationAdapter authenticationPort,
                       UserAdapter userAdapter,
                       PasswordEncoder passwordEncoder) {
        this.authenticationPort = authenticationPort;
        this.userAdapter = userAdapter;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Autentica un usuario y genera un token JWT con su rol.
     *
     * @param credentials credenciales del usuario
     * @return TokenResponse con el JWT y datos asociados
     * @throws BusinessException si las credenciales son inválidas
     */
    public TokenResponse authenticate(AuthCredentials credentials) throws Exception {
        // 🔹 Validar que las credenciales no sean nulas
        if (credentials == null ||
            credentials.getUsername() == null ||
            credentials.getPassword() == null) {
            throw new BusinessException("Credenciales inválidas");
        }

        // 🔹 Buscar usuario por username
        Optional<User> userOpt = userAdapter.findByUsername(credentials.getUsername());

        if (userOpt.isEmpty()) {
            throw new BusinessException("Usuario no encontrado");
        }

        User user = userOpt.get();

        // 🔹 Validar la contraseña
        if (!passwordEncoder.matches(credentials.getPassword(), user.getPassword())) {
            throw new BusinessException("Contraseña incorrecta");
        }

        // 🔹 Generar token con el rol del usuario
        return authenticationPort.authenticate(credentials, user.getRole().name());
    }

	public User save(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}
