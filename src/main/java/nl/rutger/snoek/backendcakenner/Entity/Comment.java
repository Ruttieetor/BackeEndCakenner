package nl.rutger.snoek.backendcakenner.Entity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Length(min = 5, max = 10000)
    private String body;
    private String fromUser;

    @ManyToOne
    @JoinColumn(name = "ratedRecipe_id")
    private RatedRecipe ratedRecipe;


    public Long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public RatedRecipe getRatedRecipe() {
        return ratedRecipe;
    }

    public void setRatedRecipe(RatedRecipe ratedRecipe) {
        this.ratedRecipe = ratedRecipe;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }


}
