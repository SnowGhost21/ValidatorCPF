package main.java;

import java.util.Scanner;

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

    private String validateCpf(String value) {
        if (!isNotNullCPF(value)) {
            return "CPF não pode ser nulo";
        }

        if (!isCPFOnlyNumbers(value)) {
            return "CPF deve conter apenas numeros";
        }

        if (!isSizeValid(value)) {
            return "CPF deve conter 11 numeros";
        }

        if (isContainsOnlySameValue(value)) {
            return "CPF inválido, informe um valor correto e tente novamente";
        }

        if (isDigitsValid(value)) {
            return "CPF válido!";
        }

        return "Erro na validação, tente novamente";
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Main validator = new Main();

        System.out.println("Informe o cpf desejado:");

        String cpf = in.next();
        String response = validator.validateCpf(cpf);

        System.out.println(response);
    }
}
