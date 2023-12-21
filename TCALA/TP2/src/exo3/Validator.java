package exo3;

class Validator {
    private ValidationStrategy strategy;

    public void setStrategy(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String input) {
        return strategy.validator(input);
    }
}