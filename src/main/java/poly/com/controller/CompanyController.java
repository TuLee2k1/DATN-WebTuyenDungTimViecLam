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
import poly.com.model.Company;
import poly.com.service.CompanyService;
import poly.com.service.MapValidationErrorService;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @Autowired
    MapValidationErrorService mapValidationErrorService;

    @PostMapping
    public ResponseEntity<?> createCompany(@Valid @RequestBody CompanyDto dto,
                                           BindingResult result) {

        ResponseEntity<?> responseEntity= mapValidationErrorService.mapValidationFields(result) ;

        if (responseEntity != null){
            return responseEntity;
        }

        Company entity = new Company();
        BeanUtils.copyProperties(dto, entity);

        entity = companyService.save(entity);
        dto.setId(entity.getId());
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<?> updateCompany(@PathVariable("id")Long id,
                                           @RequestBody CompanyDto dto) {
        Company entity = new Company();
        BeanUtils.copyProperties(dto, entity);

        entity = companyService.update(id, entity);

        dto.setId(entity.getId());

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }


    @GetMapping()
    public ResponseEntity<?> getCompany(){
        return new ResponseEntity<>(companyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<?> getCompany(
            @PageableDefault(size = 5, sort = "name", direction = Sort.Direction.ASC)
            Pageable pageable){

        return new ResponseEntity<>(companyService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}/get")
    public ResponseEntity<?> getCompany(@PathVariable("id")Long id){

        return new ResponseEntity<>(companyService.findById(id), HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable("id")Long id){
        companyService.deleteById(id);

        return new ResponseEntity<>("Company with Id " + id + " was deleted", HttpStatus.OK);
    }
}
