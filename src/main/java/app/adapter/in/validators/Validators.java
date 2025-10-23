package app.adapter.in.validators;

public abstract class Validators {

    public String stringValidator(String element, String value) throws Exception {
        if (value == null || value.equals("")) {
            throw new Exception(element + " no puede tener un valor vacío o nulo");
        }
        return value;
    }

    public int integerValidator(String element, String value) throws Exception {
        stringValidator(element, value);
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            throw new Exception(element + " debe ser un valor numérico");
        }
    }

    public long longValidator(String element, String value) throws Exception {
        stringValidator(element, value);
        try {
            return Long.parseLong(value);
        } catch (Exception e) {
            throw new Exception(element + " debe ser un valor numérico");
        }
    }

    public double doubleValidator(String element, String value) throws Exception {
        stringValidator(element, value);
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            throw new Exception(element + " debe ser un valor numérico");
        }
    }
}
