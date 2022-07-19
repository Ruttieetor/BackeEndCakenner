package nl.rutger.snoek.backendcakenner.Repository;

import nl.rutger.snoek.backendcakenner.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepo extends JpaRepository<Role, String> {


}
