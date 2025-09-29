package app.application.usecase;

import app.domain.model.User;
import app.domain.Enum.Role;
import app.domain.repository.UserRepository;
import app.domain.valueobject.UserId;

public class UserUseCase {

	private UserRepository userRepository;

	void create(User user) {

	}

	void changeRole(UserId userId, Role role) {

	}

}