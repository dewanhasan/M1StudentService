package ie.atu.studentservicem1;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/getCourse")
    public List<Course> getAllCourses(){
        return courseService.getCourse();
    }

    @GetMapping("/student/{studentId}")
    public List<Course> getCourseById(@PathVariable Long studentId){
        return courseService.getCourseByStudentId(studentId);
    }

    @PostMapping("/addCourse")
    public Course registerCourse(@RequestBody Course course) {
        courseService.addCourse(course);
        return course;
    }
}
