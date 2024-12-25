package ie.atu.studentservicem1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<StudentDetails> studentList = new ArrayList<>();

    public List<StudentDetails> getAllStudents() {
        return studentList;
    }

    public StudentDetails addStudent(StudentDetails studentDetails) {
        studentList.add(studentDetails);
        return studentDetails;
    }
}
