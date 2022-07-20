package nl.rutger.snoek.backendcakenner.Service;

import nl.rutger.snoek.backendcakenner.Dto.AccountCreatedDto;
import nl.rutger.snoek.backendcakenner.Dto.CreateAccountDto;
import nl.rutger.snoek.backendcakenner.Entity.Account;
import nl.rutger.snoek.backendcakenner.Entity.Role;
import nl.rutger.snoek.backendcakenner.Exceptions.UsernameExistsException;
import nl.rutger.snoek.backendcakenner.Repository.AccountRepo;
import nl.rutger.snoek.backendcakenner.Repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
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

        Account account = new Account();
        account.setUsername(createAccountDto.getUsername());
        account.setPassword(createAccountDto.getPassword());
        account.setEmail(createAccountDto.getEmail());
        accountRepo.save(account);

        AccountCreatedDto accountCreatedDto = new AccountCreatedDto();
        accountCreatedDto.setUsername(createAccountDto.getUsername());

        return accountCreatedDto;

    }


    public void initRolesAndUser(){
        Account adminAccount = new Account();
        Role adminRole = new Role();
        adminAccount.setUsername("admin");
        adminAccount.setPassword("admin");
        adminAccount.setEmail("Admin@admin.nl");
        Set<Role> adminRoles = new HashSet<>();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin Role");
        adminRoles.add(adminRole);

        Account userAccount = new Account();
        Role userRole = new Role();
        userAccount.setUsername("user");
        userAccount.setPassword("user");
        userAccount.setEmail("user@user.nl");
        Set<Role> userRoles = new HashSet<>();
        userRole.setRoleName("User");
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
