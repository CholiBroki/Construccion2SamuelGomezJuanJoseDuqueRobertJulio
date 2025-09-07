package app.application.port.in.user;

import app.domain.model.Role;
import app.domain.valueobject.UserId;

public interface ChangeUserRoleUseCase {
    void changeRole(UserId userId, Role role);
}