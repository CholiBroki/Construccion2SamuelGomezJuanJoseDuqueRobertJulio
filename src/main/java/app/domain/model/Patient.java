package app.domain.model;

import app.domain.valueobject.*;

public class Patient {
    private final Id id;
    private String firstName;
    private String lastName;
    private final DateOfBirth dateOfBirth;
    private String gender;
    private String address;
    private Email email;
    private Phone phone;
    private String medicalRecord;


    private String emergencyFirstName;
    private String emergencyLastName;
    private String emergencyRelation;
    private Phone emergencyPhone;

    public Patient(Id id, String firstName, String lastName,
                   DateOfBirth dateOfBirth, String gender,
                   String address, Email email, Phone phone,
                   String medicalRecord,
                   String emergencyFirstName, String emergencyLastName,
                   String emergencyRelation, Phone emergencyPhone) {

        if(id == null) throw new IllegalArgumentException("Id no puede ser null");
        if(firstName == null || firstName.isBlank()) throw new IllegalArgumentException("Nombre inválido");
        if(lastName == null || lastName.isBlank()) throw new IllegalArgumentException("Apellido inválido");
        if(dateOfBirth == null) throw new IllegalArgumentException("Fecha de nacimiento inválida");
        if(gender == null || gender.isBlank()) throw new IllegalArgumentException("Género inválido");
        if(address == null || address.isBlank()) throw new IllegalArgumentException("Dirección inválida");
        if(phone == null) throw new IllegalArgumentException("Teléfono inválido");
        if(emergencyFirstName == null || emergencyFirstName.isBlank()) throw new IllegalArgumentException("Nombre contacto emergencia inválido");
        if(emergencyLastName == null || emergencyLastName.isBlank()) throw new IllegalArgumentException("Apellido contacto emergencia inválido");
        if(emergencyRelation == null || emergencyRelation.isBlank()) throw new IllegalArgumentException("Relación contacto emergencia inválida");
        if(emergencyPhone == null) throw new IllegalArgumentException("Teléfono contacto emergencia inválido");

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.medicalRecord = medicalRecord;

        this.emergencyFirstName = emergencyFirstName;
        this.emergencyLastName = emergencyLastName;
        this.emergencyRelation = emergencyRelation;
        this.emergencyPhone = emergencyPhone;
    }


    public Id getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public DateOfBirth getDateOfBirth() { return dateOfBirth; }
    public String getGender() { return gender; }
    public String getAddress() { return address; }
    public Email getEmail() { return email; }
    public Phone getPhone() { return phone; }
    public String getMedicalRecord() { return medicalRecord; }
    public String getEmergencyFirstName() { return emergencyFirstName; }
    public String getEmergencyLastName() { return emergencyLastName; }
    public String getEmergencyRelation() { return emergencyRelation; }
    public Phone getEmergencyPhone() { return emergencyPhone; }

    // Metodos de negocio
    public void changeName(String newFirstName, String newLastName) {
        if (newFirstName == null || newFirstName.isBlank()) throw new IllegalArgumentException("Nombre inválido");
        if (newLastName == null || newLastName.isBlank()) throw new IllegalArgumentException("Apellido inválido");
        this.firstName = newFirstName;
        this.lastName = newLastName;
    }

    public void changeAddress(String newAddress) {
        if (newAddress == null || newAddress.isBlank()) throw new IllegalArgumentException("Dirección inválida");
        this.address = newAddress;
    }

    public void changeEmail(Email newEmail) {
        if (newEmail == null) throw new IllegalArgumentException("Email no puede ser null");
        this.email = newEmail;
    }

    public void changePhone(Phone newPhone) {
        if (newPhone == null) throw new IllegalArgumentException("Phone no puede ser null");
        this.phone = newPhone;
    }

    public void updateMedicalRecord(String newRecord) {
        if (newRecord == null) throw new IllegalArgumentException("Registro médico no puede ser null");
        this.medicalRecord = newRecord;
    }

    public void changeEmergencyContact(String firstName, String lastName, String relation, Phone phone) {
        if(firstName == null || firstName.isBlank()) throw new IllegalArgumentException("Nombre contacto emergencia inválido");
        if(lastName == null || lastName.isBlank()) throw new IllegalArgumentException("Apellido contacto emergencia inválido");
        if(relation == null || relation.isBlank()) throw new IllegalArgumentException("Relación contacto emergencia inválida");
        if(phone == null) throw new IllegalArgumentException("Teléfono contacto emergencia inválido");

        this.emergencyFirstName = firstName;
        this.emergencyLastName = lastName;
        this.emergencyRelation = relation;
        this.emergencyPhone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return id.equals(patient.id);
    }

    @Override
    public int hashCode() { return id.hashCode(); }
}