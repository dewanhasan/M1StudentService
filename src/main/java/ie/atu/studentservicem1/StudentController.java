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

    @GetMapping("/getAll/{lastname}")
    public ResponseEntity<StudentDetails> getBylastname(@PathVariable String lastname){
        StudentDetails selectedStudent = studentService.getDetailsbylastname(lastname);
        return ResponseEntity.ok(selectedStudent);
    }


    @PostMapping ("/add")
    public ResponseEntity<StudentDetails> addStudent(@Valid @RequestBody StudentDetails studentDetails){
        StudentDetails addedStudent = studentService.addStudent(studentDetails);
        return ResponseEntity.ok(addedStudent);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<StudentDetails>> removeStudent(@PathVariable Long id){
        List<StudentDetails> remainingStudents = studentService.deleteStudentById(id);
        return ResponseEntity.ok(remainingStudents);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDetails> updateStudentDetails(@PathVariable Long id, @RequestBody StudentDetails studentDetails){
        StudentDetails updatedStudent = studentService.updateStudentById(id, studentDetails);
        return ResponseEntity.ok(updatedStudent);
    }


}
