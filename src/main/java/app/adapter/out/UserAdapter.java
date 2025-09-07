package app.adapter.out;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import app.domain.model.User;
import app.domain.repository.UserRepository;
import app.domain.valueobject.Id;
import app.domain.valueobject.UserId;

@Service
public class UserAdapter implements UserRepository {

	@Override
	public void save(User user) {
		System.out.println("Usuario creado");
		
	}

	@Override
	public void delete(UserId id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<User> findById(UserId id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void delete(Id id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<User> findByUsername(String username) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
