package nl.rutger.snoek.backendcakenner.Controller;


import nl.rutger.snoek.backendcakenner.Dto.AccountCreatedDto;
import nl.rutger.snoek.backendcakenner.Dto.CreateAccountDto;
import nl.rutger.snoek.backendcakenner.Entity.Account;
import nl.rutger.snoek.backendcakenner.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostConstruct
    public void initRolesAndUsers(){
        accountService.initRolesAndUser();
    }


    @PostMapping("register")
    public CreateAccountDto Register(@Validated@RequestBody CreateAccountDto createAccountDto){
       AccountCreatedDto ac = accountService.Register(createAccountDto);

        return createAccountDto;

    }

    @GetMapping("/foradmin")
    public String forAdmin(){
        return " for admins only ";
    }

    @GetMapping("/foruser")
    public String forUser(){
        return " for users only ";
    }
}
