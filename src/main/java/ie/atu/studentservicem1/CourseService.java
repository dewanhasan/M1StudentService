package ie.atu.studentservicem1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    public CourseRepository courseRepository;

    @Autowired

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourse() {
        return courseRepository.findAll();
    }

    public List<Course> getCourseByStudentId(Long studentId){
        return courseRepository.findByStudentId(studentId);
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

}
