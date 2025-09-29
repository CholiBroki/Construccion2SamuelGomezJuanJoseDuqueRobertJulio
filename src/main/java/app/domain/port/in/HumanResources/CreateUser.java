package app.domain.port.in.HumanResources;

import java.util.List;

import app.domain.repository.HumanResourcesRepository;

public class CreateUser {
	private final HumanResourcesRepository humanResourcesRepository;
	
	public CreateUser(HumanResourcesRepository humanResourcesRepository) {
		this.humanResourcesRepository = humanResourcesRepository;
	}
	public void createEmployee(HumanResourcesRepository createEmployee) {
		HumanResourcesRepository.save(createEmployee);
	}
}
