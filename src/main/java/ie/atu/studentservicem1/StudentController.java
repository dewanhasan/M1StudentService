package ie.atu.studentservicem1;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    public final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentDetails>> getAllStudents(){
        List<StudentDetails> findAllStudents = studentService.getAllStudents();
        return ResponseEntity.ok(findAllStudents);
    }


    @PostMapping ("/add")
    public ResponseEntity<StudentDetails> addStudent(@Valid @RequestBody StudentDetails studentDetails){
        StudentDetails addedStudent = studentService.addStudent(studentDetails);
        return ResponseEntity.ok(addedStudent);
    }

}
