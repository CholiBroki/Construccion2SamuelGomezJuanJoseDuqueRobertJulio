package app.domain.repository;

import app.domain.model.HumanResources;
import app.domain.valueobject.Id;

import java.util.Optional;
import java.util.List;

public interface HumanResourcesRepository {
	public List<HumanResources> updateEmployee(HumanResourcesRepository updateEmployee);
	public void createEmployee(HumanResourcesRepository createEmployee);
	public void deleteEmployee(Id deleteEmployee);
	static void save(HumanResourcesRepository createEmployee) {}
	public Optional<HumanResources> findById(Long hrId);
	public static void save(HumanResources member) {}
}

