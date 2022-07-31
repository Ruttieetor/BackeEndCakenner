package nl.rutger.snoek.backendcakenner.Controller;

import nl.rutger.snoek.backendcakenner.Dto.RecipeDto;
import nl.rutger.snoek.backendcakenner.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping("/postRecipe")
    public RecipeDto PostRecipe(@RequestBody RecipeDto recipeDto) {
        recipeService.saveRecipe(recipeDto);
        return recipeDto;
    }

    @GetMapping("/showAllRecipes")
    public List<RecipeDto> getAll() {
        return recipeService.getAll();

    }

    @GetMapping("/showbyIdRecipe/{id}")
    public RecipeDto getByID(@PathVariable long id) {
        return recipeService.getByID(id);

    }
}
