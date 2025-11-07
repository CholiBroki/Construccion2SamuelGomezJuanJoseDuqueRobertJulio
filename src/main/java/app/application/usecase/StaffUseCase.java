package app.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.User;
import app.domain.Enum.Role;
import app.domain.service.UserManagementService;

@Service
public class StaffUseCase {

    @Autowired
    private UserManagementService userManagementService;

    public User crearDoctor(User user) {
        System.out.println("👨‍⚕️ [StaffUseCase] Creando doctor: " + user.getUsername());
        user.setRole(Role.DOCTOR);
        return userManagementService.crearUsuario(user);
    }

    public User crearEnfermero(User user) {
        System.out.println("👩‍⚕️ [StaffUseCase] Creando enfermero: " + user.getUsername());
        user.setRole(Role.NURSE);
        return userManagementService.crearUsuario(user);
    }
}

