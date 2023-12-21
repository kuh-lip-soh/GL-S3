package exo3;

public class Main {
    public static void main(String[] args) {
        Validator validator = new Validator();

        // Test and validate integer
        ValidationStrategy integerStrategy = new IntegerValidationStrategy();
        validator.setStrategy(integerStrategy);

        String integer1 = "aaa";
        boolean validationRes = validator.validate(integer1);
        System.out.println("Input '" + integer1 + "' is a valid integer? " + validationRes);

        String integer2 = "22";
        validationRes = validator.validate(integer2);
        System.out.println("Input'" + integer2 + "' is a valid integer? " + validationRes);

        // Test and validate Email
        ValidationStrategy emailStrategy = new EmailValidationStrategy();
        validator.setStrategy(emailStrategy);

        String email1 = "testexample.com";
        validationRes = validator.validate(email1);
        System.out.println("Input '" + email1 + "' is a valid Email? " + validationRes);

        String email2 = "testexample@domain.com";
        validationRes = validator.validate(email2);
        System.out.println("Input '" + email2 + "' is a valid Email? " + validationRes);
    }
}