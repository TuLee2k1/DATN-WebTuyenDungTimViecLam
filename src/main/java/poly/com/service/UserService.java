package poly.com.service;

import poly.com.dto.UserDTO;
import poly.com.model.User;
import poly.com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public User update(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id);
        if (user != null) {
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            return userRepository.save(user);
        }
        return null; // Hoặc ném một exception nếu không tìm thấy
    }

    public boolean delete(Long id) {
        return userRepository.delete(id);
    }
}
