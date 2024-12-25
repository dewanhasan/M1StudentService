package ie.atu.studentservicem1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final DatabaseRepo databaseRepo;

    public StudentService(DatabaseRepo databaseRepo) {
        this.databaseRepo = databaseRepo;
    }

    //private List<StudentDetails> studentList = new ArrayList<>();

    public List<StudentDetails> getAllStudents() {

        return databaseRepo.findAll();
    }

    public StudentDetails addStudent(StudentDetails studentDetails) {
        return databaseRepo.save(studentDetails);
    }
}
