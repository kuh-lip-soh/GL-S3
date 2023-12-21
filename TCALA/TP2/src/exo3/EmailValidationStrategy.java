package exo3;

class EmailValidationStrategy implements ValidationStrategy {
    public boolean validator(String email) {

        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }
}