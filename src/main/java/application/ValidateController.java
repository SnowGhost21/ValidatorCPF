package application;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

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

    @RequestMapping(value = "/validate/{cpf}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> validateWithGet(@PathVariable("cpf") String cpf) {
        LinkedHashMap<String, String> response = new LinkedHashMap<>();
        response.put("response", validateCpf(cpf));
        return response;
    }
}
