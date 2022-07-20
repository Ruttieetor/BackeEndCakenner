package nl.rutger.snoek.backendcakenner.Dto;

import javax.validation.constraints.NotEmpty;

public class AccountCreatedDto {

    private String username;

    @NotEmpty
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
