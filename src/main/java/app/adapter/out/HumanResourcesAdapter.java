package app.adapter.out;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import app.domain.model.HumanResources;
import app.domain.repository.HumanResourcesRepository;
import app.domain.valueobject.Id;

@Service
public class HumanResourcesAdapter implements HumanResourcesRepository{

	@Override
	public List<HumanResources> updateEmployee(HumanResourcesRepository updateEmployee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createEmployee(HumanResourcesRepository createEmployee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(Id deleteEmployee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<HumanResources> findById(Long hrId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}