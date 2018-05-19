package application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidateController {

    @RequestMapping(value = "/")
    public String index() {
        return String.format("");
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST, produces = "text/plain")
    @ResponseBody
    public String validateCpf(String value) {
        Main main = new Main();
        if (!main.isNotNullCPF(value)) {
            return "CPF não pode ser nulo";
        }

        if (!main.isCPFOnlyNumbers(value)) {
            return "CPF deve conter apenas numeros";
        }

        if (!main.isSizeValid(value)) {
            return "CPF deve conter 11 numeros";
        }

        if (main.isContainsOnlySameValue(value)) {
            return "CPF inválido, informe um valor correto e tente novamente";
        }

        if (main.isDigitsValid(value)) {
            return "CPF válido!";
        }

        return "Erro na validação, tente novamente";
    }
}
