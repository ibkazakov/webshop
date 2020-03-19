package shop.security.service;

import shop.security.dto.RoleDTO;
import shop.security.dto.RoleMapper;
import shop.security.repository.RoleRepository;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Stateless
public class RoleService implements Serializable {
    @Inject
    private RoleRepository roleRepository;

    @Inject
    private RoleMapper mapper;

    @TransactionAttribute
    public List<RoleDTO> getAllRoles() {
        return mapper.toRoleDTO(roleRepository.getAllRoles());
    }
}
