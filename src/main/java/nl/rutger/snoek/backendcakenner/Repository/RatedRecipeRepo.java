package nl.rutger.snoek.backendcakenner.Repository;

import nl.rutger.snoek.backendcakenner.Entity.RatedRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RatedRecipeRepo extends JpaRepository<RatedRecipe, Long> {

}
