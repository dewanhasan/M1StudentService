package ie.atu.studentservicem1;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "registration", url = "http://localhost:8082")
public interface RegistrationClient {
    @PostMapping("/approved")
    Map<String, String> confirmRegistration(@RequestBody StudentDetails studentDetails);

    @PostMapping("/register")
    Map<String, String> registedStudentAndCourses(@RequestBody StudentCourseRequest studentCourseRequest);
}
