package nl.rutger.snoek.backendcakenner.Controller;


import nl.rutger.snoek.backendcakenner.Dto.AccountCreatedDto;
import nl.rutger.snoek.backendcakenner.Dto.CreateAccountDto;
import nl.rutger.snoek.backendcakenner.Entity.Account;
import nl.rutger.snoek.backendcakenner.Service.AccountService;
import nl.rutger.snoek.backendcakenner.Util.DBFiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@CrossOrigin
@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Autowired
    private DBFiller dbFiller;


    @PostConstruct
    public void initRolesAndUsers(){
        dbFiller.initRatedRecipeAndComment();
        dbFiller.initRolesAndUser();
    }


    @PostMapping("register")
    public CreateAccountDto Register(@Validated@RequestBody CreateAccountDto createAccountDto){
       AccountCreatedDto ac = accountService.Register(createAccountDto);

        return createAccountDto;

    }

    @GetMapping("/foradmin")
    public String forAdmin(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication.getPrincipal() instanceof UserDetails)
        {
            UserDetails ud = (UserDetails) authentication.getPrincipal();
            return "hallo" + ud.getUsername() + " met rollen " + ud.getAuthorities().toString();
        }
        return " for admins only ";
    }

    @GetMapping("/foruser")
    public String forUser(){
        return " for users only ";
    }
}
