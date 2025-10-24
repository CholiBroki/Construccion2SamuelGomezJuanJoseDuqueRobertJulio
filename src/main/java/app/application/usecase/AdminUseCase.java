package app.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.User;
import app.domain.Enum.Role;
import app.domain.service.UserService;
@Service
public class AdminUseCase {
	@Autowired
	private UserService createUser;

	public void createVeterinarian(User user) throws Exception {
		user.setRole(Role.DOCTOR);
		createUser.create(user);
	}
	
	public User createSeller(User user) throws Exception {
		user.setRole(Role.PATIENT);
		createUser.create(user);
		return user;
	}

	public User createDoctor(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
