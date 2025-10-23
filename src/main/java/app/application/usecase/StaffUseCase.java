package app.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Staff;
import app.domain.model.User;
import app.domain.Enum.Role;
import app.domain.repository.StaffRepository;
import app.domain.service.UserManagementService;

@Service
public class StaffUseCase {
	
	@Autowired
	private UserManagementService userManagementService;
	
	public void CreateDoctor(User user) throws Exception {
		user.setRole(Role.DOCTOR);
		userManagementService.create(user);
	}
	
	public void createNurse(User user) throws Exception {
		user.setRole(Role.NURSE);
		userManagementService.create(user);
	}

}
