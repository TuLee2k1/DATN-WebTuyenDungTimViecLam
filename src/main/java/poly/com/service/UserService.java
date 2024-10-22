package poly.com.service;

import poly.com.dto.UserDTO;
import poly.com.model.User;
import poly.com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User findByIdAndUsername(Long id, String username) {
        User user = userRepository.findById(id);
        if (user != null && user.getUsername().equals(username)) {
            return user;
        }
        return null;
    }

    public User update(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id);
        if (user != null) {
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            return userRepository.save(user);
        }
        return null;
    }

    public boolean delete(Long id) {
        return userRepository.delete(id);
    }
}
