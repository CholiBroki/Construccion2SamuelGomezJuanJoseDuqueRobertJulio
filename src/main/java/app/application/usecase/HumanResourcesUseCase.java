package app.application.usecase;

import java.util.List;

import app.domain.model.HumanResources;
import app.domain.repository.HumanResourcesRepository;
import app.domain.valueobject.Id;

public class HumanResourcesUseCase {

	private HumanResourcesRepository humanResourcesRepository;

	public void createEmployee(HumanResourcesRepository createEmployee) {
		HumanResourcesRepository.save(createEmployee);
	}

	public void deleteEmployee(Id deleteEmployee) {
		
	}
	public List<HumanResources> updateEmployee(HumanResourcesRepository updateEmployee){
		return (List<HumanResources>) updateEmployee;
	}

}