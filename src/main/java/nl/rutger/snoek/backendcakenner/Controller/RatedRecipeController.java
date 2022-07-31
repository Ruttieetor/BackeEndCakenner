package nl.rutger.snoek.backendcakenner.Controller;


import nl.rutger.snoek.backendcakenner.Dto.RatedRecipeDto;
import nl.rutger.snoek.backendcakenner.Dto.RatedRecipeWithCommentsDto;
import nl.rutger.snoek.backendcakenner.Entity.RatedRecipe;
import nl.rutger.snoek.backendcakenner.Exceptions.RecordNotFoundException;
import nl.rutger.snoek.backendcakenner.Service.RatedRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class RatedRecipeController {


    @Autowired
    private RatedRecipeService ratedRecipeService;


    @GetMapping("/showAllRated")
    public List<RatedRecipeDto> getAll(){
        return ratedRecipeService.getAll();

    }

    @GetMapping("/recipe/{id}")
    public RatedRecipeWithCommentsDto getByID(@PathVariable long id) {
        return ratedRecipeService.getByID(id);
    }


    @PostMapping("/saverated")
    public RatedRecipeDto saveRated(@RequestBody RatedRecipeDto ratedRecipeDto){

        return ratedRecipeService.saveRated(ratedRecipeDto);
    }

}
