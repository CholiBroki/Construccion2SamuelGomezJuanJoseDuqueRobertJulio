package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class UserValidator extends Validators {

	public String nameValidator(String name) throws Exception {
		stringValidator("El nombre", name);
		if (!name.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
			throw new Exception("El nombre solo puede contener letras");
		}
		return name;
	}

	public String validateDocument(String document) throws Exception {
		stringValidator("La cédula", document);
		if (!document.matches("\\d+")) {
			throw new Exception("La cédula debe contener solo números");
		}
		return document;
	}

	public int ageValidator(String age) throws Exception {
		int value = integerValidator("La edad", age);
		if (value <= 0 || value > 120) {
			throw new Exception("La edad debe estar entre 1 y 120 años");
		}
		return value;
	}

	public String userNameValidator(String userName) throws Exception {
		stringValidator("El nombre de usuario", userName);
		if (userName.length() < 6) {
			throw new Exception("El nombre de usuario debe tener al menos 6 caracteres");
		}

		if (userName.matches(".*[áéíóúÁÉÍÓÚ].*")) {
			throw new Exception("El nombre de usuario no puede contener tildes");
		}

		return userName;
	}

	public String passwordValidator(String password) throws Exception {
		stringValidator("La contraseña", password);

		if (password.length() < 8) {
			throw new Exception("La contraseña debe tener al menos 8 caracteres");
		}

		return password;
	}
}
