package nl.rutger.snoek.backendcakenner.Controller;


import nl.rutger.snoek.backendcakenner.Dto.CreateRoleDto;
import nl.rutger.snoek.backendcakenner.Entity.Role;
import nl.rutger.snoek.backendcakenner.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RoleController {


    private final RoleService roleService;


    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @PostMapping("newRole")
    public CreateRoleDto createRole(@Validated @RequestBody CreateRoleDto createRoleDto){
        return roleService.createNewRole(createRoleDto);
    }

    @GetMapping("getRoles")
    public List<Role> GetRoles(){
        return roleService.GetRoles();
    }




}
