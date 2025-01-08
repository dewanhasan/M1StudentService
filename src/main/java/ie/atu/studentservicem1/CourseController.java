package ie.atu.studentservicem1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Course")
public class CourseController {

    private final CourseService courseService;

    // Declared CourseService class as constructor
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    //To get all courses
    @GetMapping("/getCourse")
    public List<Course> getAllCourses(){
        return courseService.getCourse();
    }

    //Get a specific students course using student ID
    @GetMapping("/student/{studentId}")
    public List<Course> getCourseById(@PathVariable Long studentId){
        return courseService.getCourseByStudentId(studentId);
    }

    //Adds a course
    @PostMapping("/addCourse")
    public Course registerCourse(@RequestBody Course course) {
        courseService.addCourse(course);
        return course;
    }
}
