package app.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.User;
import app.domain.Enum.Role;
import app.domain.service.UserService;

@Service
public class AdminUseCase {
    
    @Autowired
    private UserService userService;

    public User createDoctor(User user) {
        user.setRole(Role.DOCTOR);
        return userService.save(user);
    }
    
    public User createSeller(User user) {
        user.setRole(Role.PATIENT);
        return userService.save(user);
    }

    public User createNurse(User user) {
        user.setRole(Role.NURSE);
        return userService.save(user);
    }

    public User createHumanResources(User user) {
        user.setRole(Role.HUMAN_RESOURCES);
        return userService.save(user);
    }

    public User createAdministrativeStaff(User user) {
        user.setRole(Role.ADMINISTRATIVE_STAFF);
        return userService.save(user);
    }
}