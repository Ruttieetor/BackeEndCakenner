package nl.rutger.snoek.backendcakenner.RepoTests;


import nl.rutger.snoek.backendcakenner.Repository.RatedRecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RatedRecipeRepoTest {

    @Autowired
    private RatedRecipeRepo ratedRecipeRepo;

}
