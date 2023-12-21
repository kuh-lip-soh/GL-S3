package exo3;

class IntegerValidationStrategy implements ValidationStrategy {
    public boolean validator(String integer) {
        try {
            Integer.parseInt(integer);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}