package nl.rutger.snoek.backendcakenner.Repository;


import nl.rutger.snoek.backendcakenner.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
}
