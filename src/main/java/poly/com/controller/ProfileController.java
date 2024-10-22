package poly.com.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import poly.com.dto.CompanyDto;
import poly.com.dto.ProfileDTO;
import poly.com.model.Company;
import poly.com.model.Profile;
import poly.com.service.MapValidationErrorService;
import poly.com.service.ProfileService;

@RestController
@Tag(name = "Profile Controller")
@RequestMapping("/api/v1/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    @Autowired
    MapValidationErrorService mapValidationErrorService;

    @Operation(summary = "Add Profile", description = "API create new Profile")
    @PostMapping
    public ResponseEntity<?> saveOrUpdate(@Valid @RequestBody ProfileDTO dto, BindingResult result) {
        ResponseEntity<?> responseEntity= mapValidationErrorService.mapValidationFields(result) ;

        if (responseEntity != null){
            return responseEntity;
        }
        Profile entity = new Profile();
        BeanUtils.copyProperties(dto, entity);

        entity = profileService.save(entity);
        dto.setId(entity.getId());
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @Operation(summary = "Update Profile", description = "API update Profile")
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable("id")Long id,
                                           @RequestBody ProfileDTO dto) {
        Profile entity = new Profile();
        BeanUtils.copyProperties(dto, entity);

        entity = profileService.update(id, entity);

        dto.setId(entity.getId());

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @Operation(summary = "Get Profile", description = "API get Profile")
    @GetMapping()
    public ResponseEntity<?> getProfile(){
        return new ResponseEntity<>(profileService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Get Profile Pageable", description = "API get Profile pageable")
    @GetMapping("/page")
    public ResponseEntity<?> getProfile(
            @PageableDefault(size = 5, sort = "name", direction = Sort.Direction.ASC)
            Pageable pageable){

        return new ResponseEntity<>(profileService.findAll(pageable), HttpStatus.OK);
    }
    @Operation(summary = "Get Profile with ID", description = "API get Profile with ID")
    @GetMapping("/{id}/getedit")
    public ResponseEntity<?> getProfile(@PathVariable("id")Long id){

        return new ResponseEntity<>(profileService.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Delete Profile", description = "API delete Profile")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfile(@PathVariable("id")Long id){
        profileService.deleteById(id);

        return new ResponseEntity<>("Profile with Id " + id + " was deleted", HttpStatus.OK);
    }
}
