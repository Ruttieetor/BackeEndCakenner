package nl.rutger.snoek.backendcakenner.Repository;

import nl.rutger.snoek.backendcakenner.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AccountRepo extends JpaRepository<Account, String> {

    Optional<Account> findAccountByUsernameIs(String username);
}
