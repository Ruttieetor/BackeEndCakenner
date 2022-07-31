package nl.rutger.snoek.backendcakenner.Service;


import nl.rutger.snoek.backendcakenner.Dto.RatedRecipeDto;
import nl.rutger.snoek.backendcakenner.Dto.RatedRecipeWithCommentsDto;
import nl.rutger.snoek.backendcakenner.Dto.RecipeDto;
import nl.rutger.snoek.backendcakenner.Entity.RatedRecipe;
import nl.rutger.snoek.backendcakenner.Entity.Recipe;
import nl.rutger.snoek.backendcakenner.Exceptions.RecordNotFoundException;
import nl.rutger.snoek.backendcakenner.Repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepo recipeRepo;

    public RecipeDto saveRecipe(RecipeDto recipeDto){
        Recipe recipe = new Recipe();
        recipe.setId(recipeDto.getId());
        recipe.setName(recipeDto.getName());
        recipe.setIngredientList(recipeDto.getIngredientList());
        recipe.setBody(recipeDto.getBody());
        recipe.setFromUser(recipeDto.getFromUser());

        recipeRepo.save(recipe);

        return recipeDto;
    }

    public List<RecipeDto> getAll(){
        return recipeRepo.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

    }


    public RecipeDto getByID(Long id) {
        Optional<Recipe> recipe = recipeRepo.findById(id);
        if (recipe.isPresent()) {
            Recipe een = recipe.get();
            RecipeDto recipeDto = convertToDto(een);
            return recipeDto;
        } else {
            throw new RecordNotFoundException("Could not find Recipe");

        }
    }

    public RecipeDto convertToDto(Recipe recipe){
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setId(recipe.getId());
        recipeDto.setName(recipe.getName());
        recipeDto.setIngredientList(recipe.getIngredientList());
        recipeDto.setBody(recipe.getBody());
        recipeDto.setFromUser(recipe.getFromUser());
        return recipeDto;

    }


}
