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

        /*
        RatedRecipeWithCommentsDto ratedRecipeWithCommentsDto = ratedRecipeService.getByID(commentDto.getId());
        Comment comment = new Comment();
        comment.setBody(commentDto.getBody());
        comment.setFromUser(commentDto.getFromUser());

        //RatedRecipe ratedRecipe = new RatedRecipe();


        ratedRecipe.setId(ratedRecipeWithCommentsDto.getId());
        ratedRecipe.setName(ratedRecipeWithCommentsDto.getName());
        ratedRecipe.setIngredientList(ratedRecipeWithCommentsDto.getIngredientList());
        ratedRecipe.setBody(ratedRecipeWithCommentsDto.getBody());
        ratedRecipe.setPictureLink(ratedRecipeWithCommentsDto.getPictureLink());
        ratedRecipe.setOpinion(ratedRecipeWithCommentsDto.getOpinion());
        ratedRecipe.setRating(ratedRecipeWithCommentsDto.getRating());
        ratedRecipe.setFromUser(ratedRecipeWithCommentsDto.getFromUser());
        ratedRecipe.setComment(ratedRecipeWithCommentsDto.getComments());

*/
            return commentDto;
        }
    }



