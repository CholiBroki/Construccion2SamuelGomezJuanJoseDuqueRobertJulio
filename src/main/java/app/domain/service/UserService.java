package app.domain.service;

import app.domain.model.User;
import app.domain.valueobject.UserId;
import app.domain.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void createUser(User user) throws Exception{
    	if (user == null || user == user) {
    		throw new Exception("El campo no debe estar vacio");
    	}
        userRepository.save(user);
    }

    public void deleUser(UserId userId){
        userRepository.delete(userId);
    }
}