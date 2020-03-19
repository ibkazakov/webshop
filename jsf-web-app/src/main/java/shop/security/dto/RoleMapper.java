package shop.security.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shop.security.entity.Role;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Stateless
public class RoleMapper {
    private static final Logger logger = LoggerFactory.getLogger(RoleMapper.class);

    public RoleDTO toRoleDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setName(role.getName());
        return roleDTO;
    }

    public Role toRole(RoleDTO roleDTO) {
        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setName(roleDTO.getName());
        return role;
    }

    public Set<RoleDTO> toRoleDTO(Set<Role> roles) {
        Set<RoleDTO> roleDTOSet = new HashSet<>();
        for(Role role : roles) {
            roleDTOSet.add(toRoleDTO(role));
        }
        return roleDTOSet;
    }

    public Set<Role> toRole(Set<RoleDTO> roleDTOS) {
        Set<Role> roleSet = new HashSet<>();
        for(RoleDTO roleDTO : roleDTOS) {
            roleSet.add(toRole(roleDTO));
        }
        return roleSet;
    }

    public List<RoleDTO> toRoleDTO(List<Role> roles) {
        List<RoleDTO> roleDTOList = new ArrayList();
        for(Role role : roles) {
            roleDTOList.add(toRoleDTO(role));
        }
        return roleDTOList;
    }

    public List<Role> toRole(List<RoleDTO> roleDTOS) {
        List<Role> roleList = new ArrayList();
        for(RoleDTO roleDTO : roleDTOS) {
            roleList.add(toRole(roleDTO));
        }
        return roleList;
    }
}

