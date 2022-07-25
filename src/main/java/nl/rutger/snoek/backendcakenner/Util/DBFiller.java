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
        ratedRecipe.setName("This is an egg");
        ratedRecipe.setIngredientList("- 1 ei");
        ratedRecipe.setBody(" egg lorem ipsum");
        ratedRecipe.setPictureLink("https://media.gettyimages.com/photos/group-of-brown-raw-eggs-one-is-broken-isolated-white-picture-id173234780?s=612x612");
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


        RatedRecipe ratedRecipe2 = new RatedRecipe();
        ratedRecipe2.setName("wooooh");
        ratedRecipe2.setIngredientList("-1 cake");
        ratedRecipe2.setBody("Cras vel pretium mi, non iaculis nibh. Vestibulum quis eleifend justo, vel rhoncus sapien. Morbi metus orci, porta non molestie commodo, tempor ac leo. Aliquam a volutpat metus. Proin nec turpis nec felis aliquet sagittis id id nunc. Nulla sit amet est turpis. Ut ullamcorper interdum sapien id dignissim. Integer vel arcu lobortis, iaculis metus eu, venenatis mi. ");
        ratedRecipe2.setPictureLink("https://i.imgur.com/tfQ0pya.png");
        ratedRecipe2.setOpinion("Just a cake");
        ratedRecipe2.setFromUser("cakefromstoreguy");
        ratedRecipe2.setRating(3);

        Comment comment2 = new Comment();
        comment2.setRatedRecipe(ratedRecipe2);
        comment2.setBody("Stolen from store");
        Set<Comment> comments2 = new HashSet<>();
        comments2.add(comment2);
        ratedRecipe2.setComment(comments2);

        ratedRecipeRepo.save(ratedRecipe2);
        commentRepo.save(comment2);

        RatedRecipe ratedRecipe3 = new RatedRecipe();
        ratedRecipe3.setName("Red velvet cake");
        ratedRecipe3.setIngredientList("-1 cake, 1 velvet");
        ratedRecipe3.setBody("lorem ipsum opsidum namella fides fides fides ruttie");
        ratedRecipe3.setPictureLink("https://www.cake-recept.nl/wp-content/uploads/2015/10/red-velvet-cake.jpg");
        ratedRecipe3.setOpinion("Red velvet cake");
        ratedRecipe3.setFromUser("Velvetboi69");
        ratedRecipe3.setRating(7);

        Comment comment3 = new Comment();
        comment3.setRatedRecipe(ratedRecipe3);
        comment3.setBody("Stolen from store");
        Set<Comment> comments3 = new HashSet<>();
        comments3.add(comment3);
        ratedRecipe2.setComment(comments3);

        ratedRecipeRepo.save(ratedRecipe3);
        commentRepo.save(comment3);

        RatedRecipe ratedRecipe4 = ratedRecipe2;
        ratedRecipe4.setName("another stolen cake");
        Comment comment4 = new Comment();
        Set<Comment> comments4 = new HashSet<>();
        comment4.setBody("bruh");
        comments4.add(comment4);
        ratedRecipe4.setComment(comments4);
        ratedRecipeRepo.save(ratedRecipe4);
        commentRepo.save(comment4);


    for(int i =0; i<10; i++){
        RatedRecipe ratedRecipex = new RatedRecipe();
        ratedRecipex.setName("Its a store cake");
        ratedRecipex.setIngredientList("-1 cake");
        ratedRecipex.setBody("lorem ipsum");
        ratedRecipex.setPictureLink("https://i.imgur.com/tfQ0pya.png");
        ratedRecipex.setOpinion("Just a cake");
        ratedRecipex.setFromUser("cakefromstoreguy");
        ratedRecipex.setRating(i);


        Comment commentx = new Comment();
        commentx.setRatedRecipe(ratedRecipe2);
        commentx.setBody("Stolen from store");
        Set<Comment> commentsx = new HashSet<>();
        commentsx.add(commentx);
        ratedRecipex.setComment(commentsx);

        ratedRecipeRepo.save(ratedRecipex);
        commentRepo.save(commentx);
    }









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
