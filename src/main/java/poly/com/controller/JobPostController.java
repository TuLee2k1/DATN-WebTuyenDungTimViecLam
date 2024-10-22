package poly.com.controller;

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
import poly.com.dto.JobPostDto;
import poly.com.model.Company;
import poly.com.model.JobPost;
import poly.com.service.JobPostService;
import poly.com.service.MapValidationErrorService;

@RestController
@RequestMapping("/api/v1/jobpost")
public class JobPostController {

    @Autowired
    JobPostService jobPostService;

    @Autowired
    MapValidationErrorService mapValidationErrorService;

    //CREATE
    @PostMapping
    public ResponseEntity<?> createJobPost(@Valid @RequestBody JobPostDto dto,
                                           BindingResult result) {

        ResponseEntity<?> responseEntity= mapValidationErrorService.mapValidationFields(result) ;

        if (responseEntity != null){
            return responseEntity;
        }

        JobPost entity = new JobPost();
        BeanUtils.copyProperties(dto, entity);

        entity = jobPostService.save(entity);
        dto.setId(entity.getId());
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    //GET ALL
    @GetMapping()
    public ResponseEntity<?> getJobPostAll(){
        return new ResponseEntity<>(jobPostService.findAll(), HttpStatus.OK);
    }

    // PAGE
    @GetMapping("/page")
    public ResponseEntity<?> getJobPostPage(
            @PageableDefault(size = 3, sort = "jobTitle", direction = Sort.Direction.ASC)
            Pageable pageable){

        return new ResponseEntity<>(jobPostService.findAll(pageable), HttpStatus.OK);
    }

    //UPADATE
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateJobPost(@PathVariable("id")Long id,
                                           @RequestBody JobPost dto) {
        JobPost entity = new JobPost();
        BeanUtils.copyProperties(dto, entity);

        entity = jobPostService.update(id, entity);

        dto.setId(entity.getId());

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }


    //GET ID
    @GetMapping("/{id}/get")
    public ResponseEntity<?> getJobPostId(@PathVariable("id")Long id){

        return new ResponseEntity<>(jobPostService.findById(id), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJobPost(@PathVariable("id")Long id){
        jobPostService.deleteById(id);

        return new ResponseEntity<>("Jop Post with Id " + id + " was deleted", HttpStatus.OK);
    }

}
