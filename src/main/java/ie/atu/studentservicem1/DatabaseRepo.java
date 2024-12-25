package ie.atu.studentservicem1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseRepo extends JpaRepository<StudentDetails, Long> {
}
