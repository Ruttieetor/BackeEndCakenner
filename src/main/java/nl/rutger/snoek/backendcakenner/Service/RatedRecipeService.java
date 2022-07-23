package nl.rutger.snoek.backendcakenner.Service;


import nl.rutger.snoek.backendcakenner.Dto.CommentDto;
import nl.rutger.snoek.backendcakenner.Dto.RatedRecipeDto;
import nl.rutger.snoek.backendcakenner.Dto.RatedRecipeWithCommentsDto;
import nl.rutger.snoek.backendcakenner.Entity.Comment;
import nl.rutger.snoek.backendcakenner.Entity.RatedRecipe;
import nl.rutger.snoek.backendcakenner.Exceptions.RecordNotFoundException;
import nl.rutger.snoek.backendcakenner.Repository.RatedRecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RatedRecipeService {

    @Autowired
    private RatedRecipeRepo ratedRecipeRepo;


    public RatedRecipeWithCommentsDto getByID(Long id) {
        Optional<RatedRecipe> ratedRecipe = ratedRecipeRepo.findById(id);
        if (ratedRecipe.isPresent()) {
            RatedRecipe een = ratedRecipe.get();
            RatedRecipeWithCommentsDto ratedRecipeWithCommentsDto = ConvertToRatedRecipeWithCommentsDto(een);
            return ratedRecipeWithCommentsDto;
        } else {
            throw new RecordNotFoundException("Could not find Recipe");

        }
    }


    public List<RatedRecipeDto> getAll(){
       return ratedRecipeRepo.findAll()
               .stream()
               .map(this::convertToDto)
               .collect(Collectors.toList());

    }

    private RatedRecipeDto convertToDto(RatedRecipe ratedRecipe){
        RatedRecipeDto ratedRecipeDto = new RatedRecipeDto();
        ratedRecipeDto.setId(ratedRecipe.getId());
        ratedRecipeDto.setName(ratedRecipe.getName());
        ratedRecipeDto.setIngredientList(ratedRecipe.getIngredientList());
        ratedRecipeDto.setBody(ratedRecipe.getBody());
        ratedRecipeDto.setPictureLink(ratedRecipe.getPictureLink());
        ratedRecipeDto.setOpinion(ratedRecipe.getOpinion());
        ratedRecipeDto.setRating(ratedRecipe.getRating());
        ratedRecipeDto.setFromUser(ratedRecipe.getFromUser());
        return ratedRecipeDto;

    }

    private RatedRecipeWithCommentsDto ConvertToRatedRecipeWithCommentsDto(RatedRecipe ratedRecipe){
        RatedRecipeWithCommentsDto ratedRecipeWithCommentsDto = new RatedRecipeWithCommentsDto();
        ratedRecipeWithCommentsDto.setId(ratedRecipe.getId());
        ratedRecipeWithCommentsDto.setName(ratedRecipe.getName());
        ratedRecipeWithCommentsDto.setBody(ratedRecipe.getBody());
        ratedRecipeWithCommentsDto.setRating(ratedRecipe.getRating());
        ratedRecipeWithCommentsDto.setFromUser(ratedRecipe.getFromUser());
        ratedRecipeWithCommentsDto.setComments(dtoCommentsConvert(ratedRecipe.getComment()));
        ratedRecipeWithCommentsDto.setIngredientList(ratedRecipe.getIngredientList());
        ratedRecipeWithCommentsDto.setOpinion(ratedRecipe.getOpinion());
        ratedRecipeWithCommentsDto.setPictureLink(ratedRecipe.getPictureLink());
        return ratedRecipeWithCommentsDto;
    }

    private Set<CommentDto> dtoCommentsConvert(Set<Comment> comments ){
        Set<CommentDto> commentDtos = new HashSet<>();
        for(Comment comment : comments){
            CommentDto temp = new CommentDto();
            temp.setId(comment.getId());
            temp.setBody(comment.getBody());
            commentDtos.add(temp);
        }

        return commentDtos;
    }
}
