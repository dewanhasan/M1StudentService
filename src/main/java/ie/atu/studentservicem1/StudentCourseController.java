package ie.atu.studentservicem1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class StudentCourseController {

    private final StudentCourseService studentCourseService;
    private final RegistrationClient registrationClient;

    public StudentCourseController(StudentCourseService studentCourseService, RegistrationClient registrationClient) {
        this.studentCourseService = studentCourseService;
        this.registrationClient = registrationClient;
    }

    @PostMapping("/student-with-course")
    public ResponseEntity<String> confirmStudentCourse(@RequestBody StudentCourseRequest studentCourseRequest) {
        studentCourseService.RegisterStudentwithCourse(studentCourseRequest);
        return ResponseEntity.ok("Student confirmed course.");
    }

    @PostMapping("/register-with-Courses")
    public ResponseEntity<Object> registerStudentWcourses(@RequestBody StudentCourseRequest studentCourseRequest){
        System.out.println("Student details with Selected Courses: " + studentCourseRequest.getStudentDetails() + " || "
        + studentCourseRequest.getCourseList());
        Object response = registrationClient.registedStudentAndCourses(studentCourseRequest);
        return ResponseEntity.ok(response);
    }

}
