package ie.atu.studentservicem1;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    private final StudentService studentService;
    private final RegistrationClient registrationClient;

    public StudentController(StudentService studentService, RegistrationClient registrationClient) {
        this.studentService = studentService;
        this.registrationClient = registrationClient;
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

    @PostMapping("/approve-and-register")
    public ResponseEntity<Object> approveAndRegister(@Valid @RequestBody StudentDetails studentDetails){
        System.out.println("Student Details Received at Student Controller: " + studentDetails);
        Object response = registrationClient.confirmRegistration(studentDetails);
        return ResponseEntity.ok(response);
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
