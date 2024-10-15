package poly.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.com.model.JobProfile;

public interface JobProfileRepository extends JpaRepository<JobProfile, Long> {
}