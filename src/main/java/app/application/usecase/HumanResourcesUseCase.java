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

	public List<HumanResources> getAllHumanResources() {
		// TODO Auto-generated method stub
		return null;
	}

	public HumanResources getHumanResourceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public HumanResources createHumanResource(HumanResources humanResources) {
		// TODO Auto-generated method stub
		return null;
	}

	public HumanResources updateHumanResource(Long id, HumanResources humanResources) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteHumanResource(Long id) {
		// TODO Auto-generated method stub
		
	}

}