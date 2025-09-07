package app.domain.model;

import app.domain.valueobject.Id;

public class Medication {
    private Id id;
    private String name;
    private String dosage; 
    private int stock;

    public Medication(Id id, String name, String dosage, int stock) {
        this.id = id;
        this.name = name;
        this.dosage = dosage;
        this.stock = stock;
    }

    public Id getId() { return id; }
    public String getName() { return name; }
    public String getDosage() { return dosage; }
    public int getStock() { return stock; }

    public void updateInfo(String name, String dosage, int stock) {
        this.name = name;
        this.dosage = dosage;
        this.stock = stock;
    }
}