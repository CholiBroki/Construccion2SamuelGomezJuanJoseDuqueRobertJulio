package app.domain.valueobject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

public class DateOfBirth {
    private final LocalDate value;

    public DateOfBirth(String fecha) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate parsed = LocalDate.parse(fecha, formatter);
            int edad = Period.between(parsed, LocalDate.now()).getYears();

            if (edad > 150) {
                throw new IllegalArgumentException("La edad no puede superar los 150 años");
            }
            this.value = parsed;
        } catch (Exception e) {
            throw new IllegalArgumentException("Fecha de nacimiento inválida. Formato esperado: DD/MM/YYYY");
        }
    }

    public LocalDate getValue() {
        return value;
    }
}
