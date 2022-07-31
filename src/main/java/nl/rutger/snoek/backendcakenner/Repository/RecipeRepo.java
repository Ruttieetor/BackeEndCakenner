package nl.rutger.snoek.backendcakenner.Repository;

import nl.rutger.snoek.backendcakenner.Entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepo extends JpaRepository<Recipe, Long> {
}
