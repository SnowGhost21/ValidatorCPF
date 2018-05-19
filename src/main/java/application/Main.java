package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Main {

    private static final int CPF_SIZE = 11;

    public boolean isSizeValid(String value) {
        return value.length() == CPF_SIZE;
    }

    public boolean isNotNullCPF(String value) {
        return value != null;
    }

    public boolean isCPFOnlyNumbers(String value) {
        return value.matches("[0-9]+");
    }

    public boolean isContainsOnlySameValue(String value) {
        char char0 = value.charAt(0);
        boolean response = false;
        for (int i = 0; i < value.length(); i++) {
            if (i > 0) {
                if (value.charAt(i - 1) == value.charAt(i)) {
                    response = true;
                } else {
                    response = false;
                }
            } else {
                continue;
            }
        }

        return response;
    }

    public boolean isDigitsValid(String value) {
        char[] firstNine = value.substring(0, 9).toCharArray();
        char[] firstTen = value.substring(0, 10).toCharArray();

        int sum = 0;
        for (int i = 0, w = 10; i < firstNine.length; i++, w--) {

            Integer firsninevalue = Character.getNumericValue(firstNine[i]);
            sum += firsninevalue * w;
        }
        sum *= 10;

        int sum2 = 0;

        for (int i = 0, w = 11; i < firstTen.length; i++, w--) {
            Integer firsttenvalue = Character.getNumericValue(firstTen[i]);
            sum2 += firsttenvalue * w;
        }
        sum2 *= 11;

        int rest = sum % 11;
        int firstDigit = Character.getNumericValue(value.charAt(9));

        int rest2 = sum2 % 11;
        int secondDigit = Character.getNumericValue(value.charAt(10));
        return rest == firstDigit && rest2 == secondDigit;
    }

    public static void main(String args[]) {
        SpringApplication.run(Main.class, args);
    }
}
