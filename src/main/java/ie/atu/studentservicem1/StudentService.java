package ie.atu.studentservicem1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final DatabaseRepo databaseRepo;

    @Autowired
    public StudentService(DatabaseRepo databaseRepo) {
        this.databaseRepo = databaseRepo;
    }


    public List<StudentDetails> getAllStudents() {

        return databaseRepo.findAll();
    }

    public StudentDetails getDetailsbylastname(String lastname){
        return databaseRepo.findByLastname(lastname).get();
    }

    public StudentDetails addStudent(StudentDetails studentDetails) {
        return databaseRepo.save(studentDetails);
    }

    public List<StudentDetails> deleteStudentById(Long id){
        databaseRepo.deleteById(id);
        return databaseRepo.findAll();
    }

    public StudentDetails updateStudentById(Long id, StudentDetails studentDetails) {
        StudentDetails existingStudents = databaseRepo.findById(id).get();

        existingStudents.setFirstname(studentDetails.getFirstname());
        existingStudents.setLastname(studentDetails.getLastname());
        existingStudents.setEmail(studentDetails.getEmail());
        existingStudents.setDob(studentDetails.getDob());
        existingStudents.setAddress(studentDetails.getAddress());
        existingStudents.setContact(studentDetails.getContact());

        return databaseRepo.save(existingStudents);
    }
}
