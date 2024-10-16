package poly.com.repository;

import poly.com.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> userList = new ArrayList<>();
    private Long idCounter = 1L;

    public User save(User user) {

        if (user.getId() != null) {

            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getId().equals(user.getId())) {
                    userList.set(i, user);
                    return user;
                }
            }
        } else {

            user.setId(idCounter++);
            userList.add(user);
        }
        return user;
    }

    public List<User> findAll() {
        return userList;
    }

    public User findById(Long id) {
        return userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public boolean delete(Long id) {

        User userToRemove = findById(id);
        if (userToRemove != null) {
            userList.remove(userToRemove);
            return true;
        }
        return false;
    }
}
