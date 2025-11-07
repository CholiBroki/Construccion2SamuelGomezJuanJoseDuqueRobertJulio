package app.domain.model;

import app.domain.valueobject.*;

public class HumanResources {
    private final Id id;
    private final String name;
    private final String lastName;
    private Email email;
    private Phone phone;
    private final DateOfBirth dateOfBirth;
    private final Username username;
    private Password password;

    public HumanResources(Id id, String name, String lastName,
                                Email email, Phone phone,
                                DateOfBirth dateOfBirth,
                                Username username, Password password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.password = password;
    }

    public Id getId() { return id; }
    public String getName() { return name; }
    public String getLastName() { return lastName; }
    public Email getEmail() { return email; }
    public Phone getPhone() { return phone; }
    public DateOfBirth getDateOfBirth() { return dateOfBirth; }
    public Username getUsername() { return username; }
    public Password getPassword() { return password; }

    // Métodos de negocio
    public void changeEmail(Email newEmail) {
        if (newEmail == null) throw new IllegalArgumentException("Email no puede ser null");
        this.email = newEmail;
    }

    public void changePhone(Phone newPhone) {
        if (newPhone == null) throw new IllegalArgumentException("Phone no puede ser null");
        this.phone = newPhone;
    }

    public void changePassword(Password newPassword) {
        if (newPassword == null) throw new IllegalArgumentException("Password no puede ser null");
        this.password = newPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HumanResources)) return false;
        HumanResources that = (HumanResources) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() { return id.hashCode(); }

	public void setEmail(Email newEmail) {}

	public void setPhone(Phone newPhone) {}
}
