package ie.atu.studentservicem1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DatabaseRepo extends JpaRepository<StudentDetails, Long> {
    //Database interface
    Optional<StudentDetails> findByLastname(String lastname);
}
