package shop.controller;

import shop.security.dto.RoleDTO;
import shop.security.dto.UserDTO;
import shop.security.entity.User;
import shop.security.service.RoleService;
import shop.security.service.UserService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class UserController implements Serializable {

    @EJB
    private UserService userService;

    @Inject
    private RoleService roleRepository;

    private UserDTO user;

    private List<RoleDTO> roles;

    private List<UserDTO> users;

    public void preLoad() {
        this.roles = roleRepository.getAllRoles();
        this.users = userService.getAllUsers();
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public List<UserDTO> getAllUsers() {
        return users;
    }

    public String editUser(UserDTO user) {
        this.user = user;
        return "/admin/users/user.xhtml?faces-redirect=true";
    }

    public void deleteUser(User user) {
        userService.delete(user.getId());
    }

    public String createUser() {
        this.user = new UserDTO();
        return "/admin/users/user.xhtml?faces-redirect=true";
    }

    public String saveUser() {
        userService.merge(this.user);
        return "/admin/users/users.xhtml?faces-redirect=true";
    }

    public List<RoleDTO> getAllRoles() {
        return roles;
    }
}
