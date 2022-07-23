package nl.rutger.snoek.backendcakenner.Service;


import nl.rutger.snoek.backendcakenner.Entity.Comment;
import nl.rutger.snoek.backendcakenner.Entity.RatedRecipe;
import nl.rutger.snoek.backendcakenner.Repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {


    @Autowired
    private CommentRepo commentRepo;


}
