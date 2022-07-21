package nl.rutger.snoek.backendcakenner.Service;

import nl.rutger.snoek.backendcakenner.Dto.AccountCreatedDto;
import nl.rutger.snoek.backendcakenner.Dto.CreateAccountDto;
import nl.rutger.snoek.backendcakenner.Entity.Account;
import nl.rutger.snoek.backendcakenner.Entity.Role;
import nl.rutger.snoek.backendcakenner.Exceptions.UsernameExistsException;
import nl.rutger.snoek.backendcakenner.Repository.AccountRepo;
import nl.rutger.snoek.backendcakenner.Repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private RoleRepo roleRepo;


    public AccountCreatedDto Register(CreateAccountDto createAccountDto){
       final Optional<Account> accountOptional = accountRepo.findAccountByUsernameIs(createAccountDto.getUsername());

       if(accountOptional.isPresent()){
           throw new UsernameExistsException(createAccountDto.getUsername());
       }

       BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        Account account = new Account();
        account.setUsername(createAccountDto.getUsername());
        account.setPassword(encoder.encode(createAccountDto.getPassword()));
        account.setEnabled(true);
        account.setEmail(createAccountDto.getEmail());
        accountRepo.save(account);

        AccountCreatedDto accountCreatedDto = new AccountCreatedDto();
        accountCreatedDto.setUsername(createAccountDto.getUsername());

        return accountCreatedDto;

    }


    public void initRolesAndUser(){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        Account adminAccount = new Account();
        Role adminRole = new Role();
        adminAccount.setUsername("admin");
        adminAccount.setPassword(encoder.encode("admin"));
        adminAccount.setEmail("Admin@admin.nl");
        adminAccount.setEnabled(true);
        Set<Role> adminRoles = new HashSet<>();
        adminRole.setRoleName("ADMIN");
        adminRole.setRoleDescription("Admin Role");
        adminRoles.add(adminRole);

        Account userAccount = new Account();
        Role userRole = new Role();
        userAccount.setUsername("user");
        userAccount.setPassword(encoder.encode("user"));
        userAccount.setEmail("user@user.nl");
        userAccount.setEnabled(true);
        Set<Role> userRoles = new HashSet<>();
        userRole.setRoleName("USER");
        userRole.setRoleDescription("Basic Role thats meant for evreyone");
        userRoles.add(userRole);
        userAccount.setRole(userRoles);

        adminRoles.add(userRole);
        adminAccount.setRole(adminRoles);

        roleRepo.save(userRole);
        accountRepo.save(userAccount);

        roleRepo.save(adminRole);
        accountRepo.save(adminAccount);
    }
}
