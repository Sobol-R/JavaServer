package com.sobol.JavaServer;

import jdk.vm.ci.code.Register;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/register")
    public RegisterResponse register(@RequestParam(value = "token", defaultValue = "") String token)  {
        if (token.isEmpty()) {
            return new RegisterResponse(Result.ERROR, "Token can't be empty");
        } else if (RegisterRepository.isRegister(token)) {
            return new RegisterResponse(Result.ERROR, "Token has been already registered");
        } else {
            RegisterRepository.register(token);
            return new RegisterResponse(Result.SUCCESS);
        }
    }

    class RegisterResponse {

        Result result;
        String message;

        public RegisterResponse(Result result, String message) {
            this.result = result;
            this.message = message;
        }

        public RegisterResponse(Result result) {
            this.result = result;
        }

        public Result getResult() {
            return result;
        }

        public String getMessage() {
            return message;
        }
    }

}
