package shop.security.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shop.security.entity.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserMapper {
    private static final Logger logger = LoggerFactory.getLogger(UserMapper.class);

    @Inject
    private RoleMapper roleMapper;

    public UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
        userDTO.setRoles(roleMapper.toRoleDTO(user.getRoles()));
        return userDTO;
    }

    public User toUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setRoles(roleMapper.toRole(userDTO.getRoles()));
        return user;
    }

    public List<UserDTO> toUserDTO(List<User> userList) {
        List<UserDTO> userDTOList = new ArrayList<>();
        for(User user : userList) {
            userDTOList.add(toUserDTO(user));
        }
        return userDTOList;
    }
}
