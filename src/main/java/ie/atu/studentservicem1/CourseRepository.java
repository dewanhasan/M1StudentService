package ie.atu.studentservicem1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

    //Course repository tp save courses to the database, can only be accessed with studentId
    List<Course> findByStudentId(Long studentId);
}
