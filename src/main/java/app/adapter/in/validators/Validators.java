package app.adapter.in.validators;

public class Validators {
    
    // Mensajes de éxito
    public static final String USER_CREATED_SUCCESS = "✅ Usuario creado exitosamente";
    public static final String DOCTOR_CREATED_SUCCESS = "✅ Doctor creado exitosamente";
    public static final String NURSE_CREATED_SUCCESS = "✅ Enfermera creada exitosamente";
    public static final String PATIENT_CREATED_SUCCESS = "✅ Paciente creado exitosamente";
    
    // Mensajes de error - Nombre
    public static final String NAME_EMPTY = "El nombre no puede estar vacío";
    public static final String NAME_ONLY_LETTERS = "El nombre solo puede contener letras y espacios";
    public static final String NAME_TOO_SHORT = "El nombre debe tener al menos 3 caracteres";
    public static final String NAME_TOO_LONG = "El nombre no puede exceder 100 caracteres";
    
    // Mensajes de error - Documento
    public static final String DOCUMENT_EMPTY = "El documento no puede estar vacío";
    public static final String DOCUMENT_ONLY_NUMBERS = "El documento debe contener solo números";
    public static final String DOCUMENT_INVALID_LENGTH = "El documento debe tener entre 6 y 15 dígitos";
    public static final String DOCUMENT_ALREADY_EXISTS = "Ya existe un usuario con este documento";
    
    // Mensajes de error - Edad
    public static final String AGE_EMPTY = "La edad no puede estar vacía";
    public static final String AGE_INVALID_NUMBER = "La edad debe ser un número válido";
    public static final String AGE_OUT_OF_RANGE = "La edad debe estar entre 18 y 120 años";
    public static final String AGE_MINOR = "La edad debe ser mayor a 18 años";
    
    // Mensajes de error - Username
    public static final String USERNAME_EMPTY = "El nombre de usuario no puede estar vacío";
    public static final String USERNAME_TOO_SHORT = "El nombre de usuario debe tener al menos 4 caracteres";
    public static final String USERNAME_TOO_LONG = "El nombre de usuario no puede exceder 20 caracteres";
    public static final String USERNAME_NO_ACCENTS = "El nombre de usuario no puede contener tildes ni caracteres especiales";
    public static final String USERNAME_ALREADY_EXISTS = "El nombre de usuario ya está en uso";
    public static final String USERNAME_INVALID_FORMAT = "El nombre de usuario solo puede contener letras, números y guiones bajos";
    
    // Mensajes de error - Contraseña
    public static final String PASSWORD_EMPTY = "La contraseña no puede estar vacía";
    public static final String PASSWORD_TOO_SHORT = "La contraseña debe tener al menos 8 caracteres";
    public static final String PASSWORD_NO_UPPERCASE = "La contraseña debe contener al menos una letra mayúscula";
    public static final String PASSWORD_NO_LOWERCASE = "La contraseña debe contener al menos una letra minúscula";
    public static final String PASSWORD_NO_NUMBER = "La contraseña debe contener al menos un número";
    public static final String PASSWORD_NO_SPECIAL = "La contraseña debe contener al menos un carácter especial (@$!%*?&#)";
    public static final String PASSWORD_WEAK = "La contraseña debe contener: mayúsculas, minúsculas, números y caracteres especiales";
}
