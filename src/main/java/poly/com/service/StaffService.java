package poly.com.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import poly.com.dto.StaffDto;
import poly.com.model.Staff;
import poly.com.repository.StaffRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Staff getStaffById(Long id) {
        return staffRepository.findById(id).orElseThrow(() -> new RuntimeException("Staff Not Found"));
    }

    @Transactional
    public Staff saveStaff(StaffDto staffDto) {
        if (staffRepository.existsByFullName(staffDto.getFullName())) {
            throw new RuntimeException("Staff already exists");
        }
        Staff staff = new Staff();
        staff.setFullName(staffDto.getFullName());
        staff.setPhoneNumber(staffDto.getPhoneNumber());
        staff.setPosition(staffDto.getPosition());
        staff.setAddress(staffDto.getAddress());
        staff.setDob(staffDto.getDob());
        return staffRepository.save(staff);
    }

    @Transactional
    public Staff updateStaff(Long id, StaffDto staffDto) {
        Staff staff = staffRepository.findById(id).orElseThrow(() -> new RuntimeException("Staff Not Found"));
        staff.setFullName(staffDto.getFullName());
        staff.setPhoneNumber(staffDto.getPhoneNumber());
        staff.setPosition(staffDto.getPosition());
        staff.setAddress(staffDto.getAddress());
        staff.setDob(staffDto.getDob());
        return staffRepository.save(staff);
    }

    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }

    private Page toPage(List list, Pageable pageable) {
        if (pageable.getOffset() >= list.size()) {
            return Page.empty();
        }
        int startIndex = (int) pageable.getOffset();
        int endIndex = ((pageable.getOffset() + pageable.getPageSize()) > list.size())
        ? list.size()
        : (int) (pageable.getOffset() + pageable.getPageSize());
        List subList = list.subList(startIndex, endIndex);
        return new PageImpl(subList, pageable, list.size());
    }

}
