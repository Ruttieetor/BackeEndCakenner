package nl.rutger.snoek.backendcakenner.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String body;

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
}
