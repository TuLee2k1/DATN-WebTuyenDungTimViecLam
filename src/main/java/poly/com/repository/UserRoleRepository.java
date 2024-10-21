package poly.com.repository;

import org.springframework.stereotype.Repository;
import poly.com.model.UserRole;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRoleRepository {
    private final List<UserRole> userRoles = new ArrayList<>();
    private long currentId = 1; // Để tự động tăng ID

    public List<UserRole> findAll() {
        return userRoles;
    }

    public UserRole save(UserRole userRole) {
        userRole.setId(currentId++);
        userRoles.add(userRole);
        return userRole;
    }

    public void deleteById(Long id) {
        userRoles.removeIf(userRole -> userRole.getId().equals(id));
    }

    public UserRole findById(Long id) {
        return userRoles.stream()
                .filter(userRole -> userRole.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public UserRole update(Long id, UserRole userRole) {
        UserRole existingUserRole = findById(id);
        if (existingUserRole != null) {
            existingUserRole.setUser_id(userRole.getUser_id());
            existingUserRole.setRole(userRole.isRole());
            return existingUserRole;
        }
        return null;
    }
}
