package ie.atu.studentservicem1;

import org.springframework.stereotype.Service;

@Service
public class StudentCourseService {

    private final StudentService studentService;

    private final CourseService courseService;

    public StudentCourseService(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public void RegisterStudentwithCourse(StudentCourseRequest studentCourseRequest){
        studentService.addStudent(studentCourseRequest.getStudentDetails());
        Long studentId = studentCourseRequest.getStudentDetails().getId();

        for (Course course : studentCourseRequest.getCourseList()) {
            course.setStudentId(studentId);
            courseService.addCourse(course);
        }
    }
}