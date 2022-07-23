package nl.rutger.snoek.backendcakenner.Controller;


import nl.rutger.snoek.backendcakenner.Dto.RatedRecipeDto;
import nl.rutger.snoek.backendcakenner.Dto.RatedRecipeWithCommentsDto;
import nl.rutger.snoek.backendcakenner.Entity.RatedRecipe;
import nl.rutger.snoek.backendcakenner.Exceptions.RecordNotFoundException;
import nl.rutger.snoek.backendcakenner.Service.RatedRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RatedRecipeController {


    @Autowired
    private RatedRecipeService ratedRecipeService;


    @GetMapping("/showAllRated")
    public List<RatedRecipeDto> getAll(){
        return ratedRecipeService.getAll();

    }

    @GetMapping("/{id}")
    public RatedRecipeWithCommentsDto getByID(@PathVariable long id) {
        return ratedRecipeService.getByID(id);
    }

}
