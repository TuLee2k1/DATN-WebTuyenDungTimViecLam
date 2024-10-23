package poly.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.com.model.User;
import poly.com.model.UserRole;
import poly.com.repository.UserRepository;
import poly.com.repository.UserRoleRepository;

import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserRepository userRepository;

    public List<UserRole> getAllUserRoles() {
        return userRoleRepository.findAll();
    }

    public UserRole createUserRole(UserRole userRole) {
        // Lấy thông tin User đầy đủ từ UserRepository dựa trên user_id
        User user = userRepository.findById(userRole.getUser_id().getId());
        if (user == null) {
            throw new RuntimeException("User not found!");
        }

        // Gán thông tin User đã lấy đầy đủ vào userRole
        userRole.setUser_id(user);

        // Sau đó lưu UserRole
        return userRoleRepository.save(userRole);
    }

    public void deleteUserRole(Long id) {
        userRoleRepository.deleteById(id);
    }

    public UserRole getUserRoleById(Long id) {
        return userRoleRepository.findById(id);
    }

    public UserRole updateUserRole(Long id, UserRole userRole) {
        UserRole existingUserRole = userRoleRepository.findById(id);
        if (existingUserRole != null) {
            User user = userRepository.findById(userRole.getUser_id().getId());
            if (user == null) {
                throw new RuntimeException("User not found!");
            }
            existingUserRole.setUser_id(user);
            existingUserRole.setRole(userRole.isRole());
            return userRoleRepository.save(existingUserRole);
        }
        return null;
    }
}
