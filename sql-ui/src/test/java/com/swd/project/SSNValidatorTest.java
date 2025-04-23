package com.swd.project;
public class SSNValidatorTest {
    public static void main(String[] args) {
        SSNValidator validator = SSNValidatorSingleton.getInstance();

        String[] testSSNs = {
            "123456789",    // valid: all digits
            "123-45-6789",  // valid: correct 11-character format with dashes
            "123-456789",   // invalid: dash missing in the right position
            "123456-789",   // invalid: dash in wrong position
            "123-45-678x"   // invalid: non-numeric character
        };

        for (String ssn : testSSNs) {
            System.out.println("SSN: " + ssn + " is valid: " + validator.validate(ssn));
        }
    }
}
