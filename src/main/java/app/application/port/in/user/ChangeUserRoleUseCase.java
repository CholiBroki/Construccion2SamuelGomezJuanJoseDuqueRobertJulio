package app.application.port.in.user;

import app.domain.Enum.Role;
import app.domain.valueobject.UserId;

public interface ChangeUserRoleUseCase {
    void changeRole(UserId userId, Role role);
}