package poly.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.com.model.Company;
import poly.com.model.Profile;
import poly.com.repository.ProfileRepository;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    public Profile save(Profile entity) {
        return profileRepository.save(entity);
    }
}
