package nl.rutger.snoek.backendcakenner.Service;


import nl.rutger.snoek.backendcakenner.Dto.CommentDto;
import nl.rutger.snoek.backendcakenner.Dto.RatedRecipeWithCommentsDto;
import nl.rutger.snoek.backendcakenner.Entity.Comment;
import nl.rutger.snoek.backendcakenner.Entity.RatedRecipe;
import nl.rutger.snoek.backendcakenner.Repository.CommentRepo;
import nl.rutger.snoek.backendcakenner.Repository.RatedRecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CommentService {


    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private RatedRecipeRepo ratedRecipeRepo;
    @Autowired
    private RatedRecipeService ratedRecipeService;
//grabs the comments from the ratedRecipes instead of just adding it to the comments it then adds it to the set
    // and then saves the now edited rated recipe.
    public CommentDto addComment(CommentDto commentDto) {

        Optional<RatedRecipe> ratedRecipe = ratedRecipeRepo.findById(commentDto.getId());
        Comment comment = new Comment();
        comment.setFromUser(commentDto.getFromUser());
        comment.setBody(commentDto.getBody());

        if (ratedRecipe.isPresent()) {
            RatedRecipe een = ratedRecipe.get();
            een.getComment().add(comment);
            comment.setRatedRecipe(een);
            ratedRecipeRepo.save(een);

        }

            return commentDto;
        }
    }



