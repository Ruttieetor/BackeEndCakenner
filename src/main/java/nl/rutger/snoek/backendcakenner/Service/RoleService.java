package nl.rutger.snoek.backendcakenner.Service;

import nl.rutger.snoek.backendcakenner.Dto.CreateRoleDto;
import nl.rutger.snoek.backendcakenner.Entity.Role;
import nl.rutger.snoek.backendcakenner.Repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleService {

    @Autowired
    RoleRepo roleRepo;

    public CreateRoleDto createNewRole(CreateRoleDto roleDto) {
        Role role = new Role();
        role.setRoleName(roleDto.getRoleName());
        role.setRoleDescription(roleDto.getRoleDescription());
        roleRepo.save(role);
        return roleDto;
    }


    public List<Role> GetRoles(){

        return roleRepo.findAll();
    }

}
