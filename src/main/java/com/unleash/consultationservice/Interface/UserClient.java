package com.unleash.consultationservice.Interface;

import com.unleash.consultationservice.DTO.DashboardDTO;
import com.unleash.consultationservice.DTO.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "user-service" )
public interface UserClient {

    @GetMapping("/api/public/selection-data")
     ResponseEntity<?> getSelectionData();


    @GetMapping("/api/public/get-user")
    public ResponseEntity<UserDto> getUserWithUserName(@RequestParam("username") String userName);

    @GetMapping("/api/user/counselor/test")
    public ResponseEntity<String> test();

    @GetMapping("/api/user/counselor/get-username")
    public String findUsername(@RequestParam int userId);

    @GetMapping("/api/user/counselor/get-all-counselors")
    public List<UserDto> findAllCounselors();

    @GetMapping("/api/user/admin/fetchpatients")
    public ResponseEntity<List<UserDto>> getPatients();

    @GetMapping("/api/user/admin/get-dashboard-data")
    public ResponseEntity<DashboardDTO>getAdminDashboradData();

    @GetMapping("/api/public/get-user/{id}")
    public ResponseEntity<UserDto> getUserWithUserId(@PathVariable("id") int id);
}
