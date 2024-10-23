package poly.com.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import poly.com.dto.UserDTO;
import poly.com.model.User;
import poly.com.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "Add new User", description = "API create new User")
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        User user = userService.save(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @Operation(summary = "Get All User", description = "API get all User")
    @GetMapping("/all") // Lấy tất cả người dùng
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @Operation(summary = "Get All User Pageable", description = "API get all user ")
    @GetMapping // Phân trang
    public ResponseEntity<Page<User>> getAllUsersPaginated(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "10") int size) {
        Page<User> users = userService.findAll(PageRequest.of(page, size));
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @Operation(summary = "Search User", description = "API search User")
    @GetMapping("/search")
    public ResponseEntity<User> getUserByIdAndUsername(@RequestParam Long id, @RequestParam String username) {
        User user = userService.findByIdAndUsername(id, username);
        return user != null ?
                new ResponseEntity<>(user, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @Operation(summary = "Update User", description = "API Update User")
    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        User updatedUser = userService.update(id, userDTO);
        return updatedUser != null ?
                new ResponseEntity<>(updatedUser, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @Operation(summary = "Delete User", description = "API Delete User")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean isDeleted = userService.delete(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
