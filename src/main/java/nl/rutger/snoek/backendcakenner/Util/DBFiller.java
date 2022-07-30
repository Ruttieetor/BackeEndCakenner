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
        ratedRecipe.setIngredientList("-1 egg,"+"\n" + "-1 egg,"+"\n" + "-1 egg,"+"\n" + "-1 egg,"+"\n" + "-1 egg,"+"\n" + "-1 egg,"+"\n" + "-1 egg,"+"\n" + "-1 egg,"+"\n" + "-1 egg,"+"\n" + "-1 egg,"+"\n" + "-1 egg,"+"\n" + "-1 egg,"+"\n" + "-1 egg,"+"\n" + "-1 egg,"+"\n" + "-1 egg,"+"\n" + "-1 egg,"+"\n" + "-1 egg,"+"\n" + "-1 egg,"+"\n" + "-1 egg,"+"\n" + "-1 egg,"+"\n" + "-1 egg,"+"\n" + "-1 egg,"+"\n");
        ratedRecipe.setBody("\n" +
                "\n" +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla sollicitudin condimentum efficitur. Quisque gravida ante quis neque ornare tempus et id lectus. Aliquam sed sapien lorem. Sed aliquam tincidunt eleifend. Mauris a commodo elit, a porta felis. Suspendisse rhoncus augue lorem, a porta enim aliquet sed. Aliquam pellentesque neque eget pharetra faucibus. Aenean facilisis aliquam faucibus.\n" +
                "\n" +
                "Nulla ac felis sit amet metus laoreet ullamcorper quis eget dolor. Suspendisse metus nibh, tempor ac augue porttitor, dictum fermentum eros. Donec convallis purus id lorem ultricies, pellentesque tristique enim imperdiet. In hac habitasse platea dictumst. Suspendisse porta sem vel metus feugiat scelerisque. Curabitur sagittis tellus et justo efficitur congue. Mauris luctus vulputate mauris id molestie. Ut scelerisque accumsan est ac imperdiet.\n" +
                "\n" +
                "Phasellus dapibus purus in molestie rhoncus. Nulla lacinia cursus orci sed convallis. Sed facilisis non enim ac euismod. Nullam hendrerit eu metus ac aliquet. Quisque pharetra dui eu dolor rhoncus, id varius nulla commodo. Maecenas porttitor rhoncus varius. Vivamus sit amet condimentum lacus. Nulla feugiat vulputate elementum. Etiam suscipit non purus a ultricies. Quisque rutrum leo mauris, a ultrices elit finibus in.\n" +
                "\n" +
                "Curabitur egestas tortor quis risus posuere rutrum faucibus ut orci. Nulla maximus velit a lorem efficitur sodales. Duis a viverra mi. Proin scelerisque tempor hendrerit. Ut ut diam scelerisque, sagittis orci nec, ullamcorper ante. Donec ultrices leo augue, in facilisis neque ornare ut. Quisque a varius nisl. Donec nibh est, laoreet ut porta at, ultrices et nisl. Donec congue elementum posuere. Donec rutrum nisi vel finibus pulvinar. Etiam dapibus dignissim nisi sed semper. In vitae velit eu libero convallis finibus quis sit amet mi. Vivamus sagittis, nisl non rhoncus placerat, lacus elit dignissim leo, id cursus diam nunc quis ante.\n" +
                "\n" +
                "In pellentesque est enim, id tempus nunc accumsan eget. Suspendisse id egestas odio, nec volutpat massa. Mauris viverra pulvinar ex, eu tincidunt tellus ornare at. Vestibulum mollis augue in lorem convallis ultrices. Duis nibh mi, tincidunt vel lectus eu, lacinia blandit nulla. Aliquam egestas velit non arcu tristique egestas. Pellentesque rhoncus condimentum mauris, vitae ultrices eros sagittis id. Phasellus at eleifend lacus. Suspendisse sagittis dictum consectetur. Quisque ultricies, dui ut vestibulum iaculis, nunc ipsum molestie est, vel accumsan massa neque eleifend dui. Donec tristique ipsum at aliquet eleifend. Quisque ornare massa nibh, eu placerat lacus vulputate id. ");
        ratedRecipe.setPictureLink("https://media.gettyimages.com/photos/group-of-brown-raw-eggs-one-is-broken-isolated-white-picture-id173234780?s=612x612");
        ratedRecipe.setOpinion(" Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla sollicitudin condimentum efficitur. Quisque gravida ante quis neque ornare tempus et id lectus. Aliquam sed sapien lorem. Sed aliquam tincidunt eleifend. Mauris a commodo elit, a porta felis. Suspendisse rhoncus augue lorem, a porta enim aliquet sed. Aliquam pellentesque neque eget pharetra faucibus. Aenean facilisis aliquam faucibus.\n" +
                "\n" +
                "Nulla ac felis sit amet metus laoreet ullamcorper quis eget dolor. Suspendisse metus nibh, tempor ac augue porttitor, dictum fermentum eros. Donec convallis purus id lorem ultricies, pellentesque tristique enim imperdiet. In hac habitasse platea dictumst. Suspendisse porta sem vel metus feugiat scelerisque. Curabitur sagittis tellus et justo efficitur congue. Mauris luctus vulputate mauris id molestie. Ut scelerisque accumsan est ac imperdiet. ");
        ratedRecipe.setFromUser("Eggman");
        ratedRecipe.setRating(0);

        Comment comment = new Comment();
        Comment comment2 = new Comment();
        comment.setRatedRecipe(ratedRecipe);
        comment2.setRatedRecipe(ratedRecipe);
        comment.setFromUser("Eggman");
        comment2.setFromUser("Shadow");
        comment.setBody("Shadow the hedhog is a bitch ass motherfucker");
        comment2.setBody("fuck you doctor");
        Set<Comment> comments = new HashSet<>();
        comments.add(comment);
        comments.add(comment2);

        ratedRecipe.setComment(comments);

        ratedRecipeRepo.save(ratedRecipe);
        commentRepo.save(comment);



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
        comment3.setFromUser("vivalaredvelvet");
        comment3.setBody("Stolen from store");
        Set<Comment> comments3 = new HashSet<>();
        comments3.add(comment3);
        ratedRecipe3.setComment(comments3);

        ratedRecipeRepo.save(ratedRecipe3);
        commentRepo.save(comment3);



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
        commentx.setRatedRecipe(ratedRecipex);
        commentx.setFromUser("X-men");
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
