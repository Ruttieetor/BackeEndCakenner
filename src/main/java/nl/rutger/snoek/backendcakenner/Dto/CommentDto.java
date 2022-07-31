package nl.rutger.snoek.backendcakenner.Dto;

import javax.validation.constraints.NotEmpty;

public class CommentDto {

    private Long id;
    private String body;
    @NotEmpty
    private String fromUser;


    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public Long getId() {
       return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
