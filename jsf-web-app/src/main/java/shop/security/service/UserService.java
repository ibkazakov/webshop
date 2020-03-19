package shop.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shop.security.dto.UserDTO;
import shop.security.dto.UserMapper;
import shop.security.entity.User;
import shop.security.repository.UserRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Stateless
public class UserService implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Inject
    private UserMapper mapper;

    @EJB
    private UserRepository userRepository;

    @TransactionAttribute
    public void merge(UserDTO userDTO) {
      userRepository.merge(mapper.toUser(userDTO));
    }

    @TransactionAttribute
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @TransactionAttribute
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @TransactionAttribute
    public boolean existsById(Long id) {
        return userRepository.findById(id) != null;
    }

    @TransactionAttribute
    public List<UserDTO> getAllUsers() {
        return mapper.
                toUserDTO(userRepository.getAllUsers());
    }

}
