package poly.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.com.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}