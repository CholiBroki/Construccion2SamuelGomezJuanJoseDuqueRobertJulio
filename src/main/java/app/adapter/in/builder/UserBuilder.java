package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.UserValidator;
import app.domain.model.User;

@Component
public class UserBuilder {
    
    @Autowired
    private UserValidator userValidator;
    
    public User build(String name, String document, String age, String userName, String password) {
        User user = new User();
        user.setName(userValidator.nameValidator(name));
        // Nota: User no tiene campo document en la base de datos actual, si lo necesitas agrégalo a la entidad
        int validatedAge = userValidator.ageValidator(age);
        user.setAge(validatedAge);
        user.setUsername(userValidator.userNameValidator(userName));
        user.setPassword(userValidator.passwordValidator(password));
        return user;
    }
}
