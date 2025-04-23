package com.swd.project;
public class SSNValidatorSingleton implements SSNValidator {

    private static final SSNValidatorSingleton INSTANCE = new SSNValidatorSingleton();

    private SSNValidatorSingleton() { }

    public static SSNValidatorSingleton getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean validate(String ssn) {
        if (ssn == null) return false;
        int len = ssn.length();
        if (len != 9 && len != 11) return false;

        if (len == 11) {
            if (ssn.charAt(3) != '-' || ssn.charAt(6) != '-') return false;
            for (int i = 0; i < len; i++) {
                if (i == 3 || i == 6) continue;
                if (!Character.isDigit(ssn.charAt(i))) return false;
            }
        } else {
            for (int i = 0; i < len; i++) {
                if (!Character.isDigit(ssn.charAt(i))) return false;
            }
        }
        return true;
    }
}
