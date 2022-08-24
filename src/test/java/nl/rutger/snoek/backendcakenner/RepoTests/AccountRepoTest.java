package nl.rutger.snoek.backendcakenner.RepoTests;


import nl.rutger.snoek.backendcakenner.Entity.Account;
import nl.rutger.snoek.backendcakenner.Repository.AccountRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AccountRepoTest {

    @Autowired
    private AccountRepo accountRepo;
    @Test
    public void SaveFindTest(){
        Account account = new Account();
        account.setUsername("Test");
        account.setPassword("test");
        account.setEmail("Test@test.nl");

        accountRepo.save(account);
        Assertions.assertNotNull(accountRepo.getReferenceById(account.getUsername()));


    }


}
