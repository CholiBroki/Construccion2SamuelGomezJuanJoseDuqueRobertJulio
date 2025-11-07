package app.infrastructure.security;

import app.adapter.out.AuthenticationAdapter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final AuthenticationAdapter authenticationPort;

    public JwtAuthenticationFilter(AuthenticationAdapter authenticationPort) {
        this.authenticationPort = authenticationPort;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        System.out.println("🔍 Verificando filtro para: " + path);
        
        // Permitir todas las rutas de autenticación sin filtro
        boolean shouldNotFilter = path.startsWith("/api/auth/") || 
                                  (request.getMethod().equals("POST") && path.equals("/users"));
        
        System.out.println("   ➡️ Debe saltar filtro: " + shouldNotFilter);
        return shouldNotFilter;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        System.out.println("🔐 Procesando filtro JWT para: " + request.getRequestURI());
        
        String token = extractToken(request);

        if (token != null) {
            System.out.println("   📝 Token encontrado: " + token.substring(0, Math.min(20, token.length())) + "...");
            
            if (authenticationPort.validateToken(token)) {
                String username = authenticationPort.extractUsername(token);
                String role = authenticationPort.extractRole(token);
                
                System.out.println("   ✅ Token válido - Usuario: " + username + " | Role: " + role);

                if (role != null && !role.trim().isEmpty()) {
                    String normalized = role.trim().toUpperCase();
                    if (!normalized.startsWith("ROLE_")) {
                        normalized = "ROLE_" + normalized;
                    }

                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        username,
                        null,
                        Collections.singletonList(new SimpleGrantedAuthority(normalized))
                    );

                    SecurityContextHolder.getContext().setAuthentication(auth);
                    System.out.println("   🎫 Autenticación establecida con rol: " + normalized);
                }
            } else {
                System.out.println("   ❌ Token inválido o expirado");
            }
        } else {
            System.out.println("   ⚠️ No se encontró token en la petición");
        }

        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        return (header != null && header.startsWith("Bearer ")) ? header.substring(7) : null;
    }
}