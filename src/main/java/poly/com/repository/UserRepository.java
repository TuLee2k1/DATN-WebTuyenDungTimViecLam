package poly.com.repository;

import poly.com.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> userList = new ArrayList<>();
    private Long idCounter = 1L;

    // Lưu người dùng
    public User save(User user) {
        if (user.getId() != null) {
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getId().equals(user.getId())) {
                    userList.set(i, user); // Cập nhật người dùng
                    return user;
                }
            }
        } else {
            user.setId(idCounter++); // Tăng ID khi thêm người dùng mới
            userList.add(user);
        }
        return user;
    }

    // Tìm tất cả người dùng
    public List<User> findAll() {
        return userList;
    }

    // Tìm tất cả người dùng với phân trang
    public Page<User> findAll(Pageable pageable) {
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), userList.size());
        return new PageImpl<>(userList.subList(start, end), pageable, userList.size());
    }

    // Tìm người dùng theo ID
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
