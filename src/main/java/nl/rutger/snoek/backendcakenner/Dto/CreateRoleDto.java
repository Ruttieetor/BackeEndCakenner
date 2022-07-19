package nl.rutger.snoek.backendcakenner.Dto;


import javax.validation.constraints.NotEmpty;

public class CreateRoleDto {

    @NotEmpty
    private String roleName;
    @NotEmpty
    private String roleDescription;


    public String getRoleName() {
        return roleName;
    }


    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
