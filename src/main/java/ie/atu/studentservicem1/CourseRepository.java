package ie.atu.studentservicem1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, String> {

    List<Course> findByStudentId(Long studentId);
}
