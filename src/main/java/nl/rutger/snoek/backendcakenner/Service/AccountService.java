package nl.rutger.snoek.backendcakenner.Service;

import nl.rutger.snoek.backendcakenner.Dto.AccountCreatedDto;
import nl.rutger.snoek.backendcakenner.Dto.CreateAccountDto;
import nl.rutger.snoek.backendcakenner.Dto.RecipeDto;
import nl.rutger.snoek.backendcakenner.Entity.Account;
import nl.rutger.snoek.backendcakenner.Entity.Recipe;
import nl.rutger.snoek.backendcakenner.Entity.Role;
import nl.rutger.snoek.backendcakenner.Exceptions.RecordNotFoundException;
import nl.rutger.snoek.backendcakenner.Exceptions.UsernameExistsException;
import nl.rutger.snoek.backendcakenner.Repository.AccountRepo;
import nl.rutger.snoek.backendcakenner.Repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;


    public AccountCreatedDto Register(CreateAccountDto createAccountDto) {
        final Optional<Account> accountOptional = accountRepo.findAccountByUsernameIs(createAccountDto.getUsername());

        if (accountOptional.isPresent()) {
            throw new UsernameExistsException(createAccountDto.getUsername());
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        Account account = new Account();
        account.setUsername(createAccountDto.getUsername());
        account.setPassword(encoder.encode(createAccountDto.getPassword()));
        account.setEnabled(true);
        account.setEmail(createAccountDto.getEmail());

        Role userRole = new Role();
        Set<Role> userRoles = new HashSet<>();
        userRole.setRoleName("USER");
        userRole.setRoleDescription("Basic Role thats meant for evreyone");
        userRoles.add(userRole);

        account.setRole(userRoles);
        accountRepo.save(account);

        AccountCreatedDto accountCreatedDto = new AccountCreatedDto();
        accountCreatedDto.setUsername(createAccountDto.getUsername());

        return accountCreatedDto;

    }

    public String getAdminuser(String username) {
        Optional<Account> temp = accountRepo.findById(username);
        if (temp.isPresent()) {
            Account een = temp.get();
            return adminYesNo(een);
        } else {
            throw new RecordNotFoundException("Could not find Account");

        }
    }

    public String adminYesNo(Account account) {
        Set<Role> temp = account.getRole();

        String admin = "no";
        Role temp2 = new Role();
        temp2.setRoleName("ADMIN");
        temp2.setRoleDescription("Admin Role");
        AtomicInteger atomicInteger = new AtomicInteger(0);

        temp.stream().forEach((Role) -> {

            if (Role.getRoleName().equals(temp2.getRoleName())) {
                atomicInteger.set(1);
            }


        });

        int atomic = atomicInteger.get();
        if (atomic == 1) {
            admin = "yes";
        }

        return admin;
    }
}



