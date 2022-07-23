package nl.rutger.snoek.backendcakenner.Util;


import nl.rutger.snoek.backendcakenner.Entity.Account;
import nl.rutger.snoek.backendcakenner.Entity.Comment;
import nl.rutger.snoek.backendcakenner.Entity.RatedRecipe;
import nl.rutger.snoek.backendcakenner.Entity.Role;
import nl.rutger.snoek.backendcakenner.Repository.AccountRepo;
import nl.rutger.snoek.backendcakenner.Repository.CommentRepo;
import nl.rutger.snoek.backendcakenner.Repository.RatedRecipeRepo;
import nl.rutger.snoek.backendcakenner.Repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Service
public class DBFiller {



    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private RatedRecipeRepo ratedRecipeRepo;


    @PostConstruct
    public void fill(){
        initRolesAndUser();
    }

    public void initRatedRecipeAndComment(){
        RatedRecipe ratedRecipe = new RatedRecipe();
        ratedRecipe.setName("Dits een ei");
        ratedRecipe.setIngredientList("- 1 ei, -nog een ei");
        ratedRecipe.setBody(" 2 eieren lorem ipsum");
        ratedRecipe.setPictureLink("");
        ratedRecipe.setOpinion("kinda eggy");
        ratedRecipe.setFromUser("Eggman");
        ratedRecipe.setRating(0);

        Comment comment = new Comment();
        comment.setRatedRecipe(ratedRecipe);
        comment.setBody("Eggy Egg egg");
        Set<Comment> comments = new HashSet<>();
        comments.add(comment);
        ratedRecipe.setComment(comments);

        ratedRecipeRepo.save(ratedRecipe);
        commentRepo.save(comment);




    }

    public void initRolesAndUser(){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        Account adminAccount = new Account();
        Role adminRole = new Role();
        adminAccount.setUsername("admin");
        adminAccount.setPassword(encoder.encode("admin"));
        adminAccount.setEmail("Admin@admin.nl");
        adminAccount.setEnabled(true);
        Set<Role> adminRoles = new HashSet<>();
        adminRole.setRoleName("ADMIN");
        adminRole.setRoleDescription("Admin Role");
        adminRoles.add(adminRole);

        Account userAccount = new Account();
        Role userRole = new Role();
        userAccount.setUsername("user");
        userAccount.setPassword(encoder.encode("user"));
        userAccount.setEmail("user@user.nl");
        userAccount.setEnabled(true);
        Set<Role> userRoles = new HashSet<>();
        userRole.setRoleName("USER");
        userRole.setRoleDescription("Basic Role thats meant for evreyone");
        userRoles.add(userRole);
        userAccount.setRole(userRoles);

        adminRoles.add(userRole);
        adminAccount.setRole(adminRoles);

        roleRepo.save(userRole);
        accountRepo.save(userAccount);

        roleRepo.save(adminRole);
        accountRepo.save(adminAccount);
    }

}
