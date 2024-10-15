package poly.com.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import poly.com.dto.StaffDto;
import poly.com.exception.ApiResponse;
import poly.com.model.Staff;
import poly.com.service.StaffService;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    private final StaffService staffService;
    private final ApiResponse<Staff> apiResponse;

    @Autowired
    public StaffController(StaffService staffService, ApiResponse<Staff> apiResponse) {
        this.staffService = staffService;
        this.apiResponse = apiResponse;
    }

    /*
     * @author: VuDD
     * @since: 10/15/2024 2:47 PM
     * @description:  Lấy danh sách tất cả nhân viên
     * @update:
     *
     * */
    @GetMapping
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    /*
     * @author: VuDD
     * @since: 10/15/2024 2:47 PM
     * @description:  Lấy thông tin nhân viên theo id
     * @update:
     *
     * */
    @GetMapping("/{id}")
    ApiResponse<Staff>  getStaffById(@PathVariable Long id) {
        try {
            apiResponse.setStatus(HttpStatus.OK.value());
            apiResponse.setResult(staffService.getStaffById(id));
            apiResponse.setMessage("User found");
        } catch (Exception e) {
            apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            apiResponse.setMessage("User not found");
            apiResponse.setResult(null);
        }
        return apiResponse;
    }


    /*
     * @author: VuDD
     * @since: 10/15/2024 2:48 PM
     * @description:  Tạo mới nhân viên
     * @update:
     *
     * */
    @PostMapping("/save")
    ApiResponse<Staff>  saveStaff(@Valid @RequestBody StaffDto staffDto) {
        try
        {
            apiResponse.setStatus(HttpStatus.OK.value());
            apiResponse.setResult(staffService.saveStaff(staffDto));
            apiResponse.setMessage("User saved");
        } catch (Exception e) {
            apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            apiResponse.setMessage("User not saved");
            apiResponse.setResult(null);
        }
        return apiResponse;
    }

    /*
     * @author: VuDD
     * @since: 10/15/2024 2:48 PM
     * @description:  Cập nhật thông tin nhân viên
     * @update:
     *
     * */
    @PatchMapping("/{id}")
    ApiResponse<Staff>  updateStaff(@PathVariable Long id, @Valid @RequestBody StaffDto staffDto) {
        try {
            apiResponse.setStatus(HttpStatus.OK.value());
            apiResponse.setResult(staffService.updateStaff(id, staffDto));
            apiResponse.setMessage("User updated");
        } catch (Exception e) {
            apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            apiResponse.setMessage("User not updated");
            apiResponse.setResult(null);
        }
        return apiResponse;
    }


    /*
     * @author: VuDD
     * @since: 10/15/2024 2:48 PM
     * @description:  Xóa nhân viên
     * @update:
     *
     * */
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteStaff(@PathVariable Long id) {
        ApiResponse<Void> apiResponse = new ApiResponse<>();
        try {
            if (staffService.getStaffById(id) == null) {
                apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
                apiResponse.setMessage("User not found");
            }
            staffService.deleteStaff(id);
            apiResponse.setStatus(HttpStatus.OK.value());
            apiResponse.setMessage("User deleted");
        } catch (Exception e) {
            apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            apiResponse.setMessage("User not deleted");
        }
        return apiResponse;
    }
}