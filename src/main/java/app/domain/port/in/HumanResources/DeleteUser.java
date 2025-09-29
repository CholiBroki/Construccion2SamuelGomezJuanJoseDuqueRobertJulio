package app.domain.port.in.HumanResources;

import app.domain.repository.HumanResourcesRepository;
import app.domain.valueobject.Id;

public class DeleteUser {
	
	private final HumanResourcesRepository humanResourcesRepository;

	public DeleteUser(HumanResourcesRepository humanResourcesRepository) {
		this.humanResourcesRepository = humanResourcesRepository;
	}
	public void deleteEmployee(Id deleteEmployee) {
		System.out.println("Usuario eliminado");
	}


}
