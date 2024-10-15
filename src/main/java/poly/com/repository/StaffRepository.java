package poly.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.com.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    boolean existsByFullName(String fullName);
}
