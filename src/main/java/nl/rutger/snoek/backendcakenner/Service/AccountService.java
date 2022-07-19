package nl.rutger.snoek.backendcakenner.Service;

import nl.rutger.snoek.backendcakenner.Dto.AccountCreatedDto;
import nl.rutger.snoek.backendcakenner.Dto.CreateAccountDto;
import nl.rutger.snoek.backendcakenner.Entity.Account;
import nl.rutger.snoek.backendcakenner.Exceptions.UsernameExistsException;
import nl.rutger.snoek.backendcakenner.Repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;


@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;


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
}
