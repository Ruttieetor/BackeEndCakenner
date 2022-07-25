package nl.rutger.snoek.backendcakenner.Entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Entity
public class RatedRecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String ingredientList;
    @Length(min = 5, max = 10000)
    private String body;
    private String pictureLink;
    @Length(min = 5, max = 10000)
    private String opinion;
    private double rating;
    private String fromUser;


    @OneToMany(targetEntity = Comment.class, mappedBy = "ratedRecipe", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Comment> comment;

    public Set<Comment> getComment() {
        return comment;
    }

    public void setComment(Set<Comment> comment) {
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(String ingredientList) {
        this.ingredientList = ingredientList;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

}
