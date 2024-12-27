package ie.atu.studentservicem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Enables Mockito in JUnit 5
public class StudentServiceTest {

    @Mock
    private DatabaseRepo databaseRepo; // Mocked database repository

    @InjectMocks
    private StudentService studentService; // Service with the mocked repo injected

    private StudentDetails student1;
    private StudentDetails student2;

    @BeforeEach
    void setUp() {
        // Create test StudentDetails objects
        student1 = new StudentDetails();
        student1.setId(1L);
        student1.setFirstname("John");
        student1.setLastname("Doe");
        student1.setEmail("john.doe@example.com");
        student1.setDob("1990-01-01");
        student1.setContact("1234567890");
        student1.setAddress("Address 1");

        student2 = new StudentDetails();
        student2.setId(2L);
        student2.setFirstname("Jane");
        student2.setLastname("Smith");
        student2.setEmail("jane.smith@example.com");
        student2.setDob("1992-05-10");
        student2.setContact("0987654321");
        student2.setAddress("Address 2");
    }

    @Test
    void testAddStudent() {
        // Arrange
        when(databaseRepo.save(student1)).thenReturn(student1);

        // Act
        StudentDetails savedStudent = studentService.addStudent(student1);

        // Assert
        assertNotNull(savedStudent);
        assertEquals("John", savedStudent.getFirstname());
        verify(databaseRepo, times(1)).save(student1);
    }

    @Test
    void testGetAllStudents() {
        // Arrange
        List<StudentDetails> mockedList = new ArrayList<>();
        mockedList.add(student1);
        mockedList.add(student2);

        when(databaseRepo.findAll()).thenReturn(mockedList);

        // Act
        List<StudentDetails> allStudents = studentService.getAllStudents();

        // Assert
        assertEquals(2, allStudents.size());
        assertEquals("John", allStudents.get(0).getFirstname());
        assertEquals("Jane", allStudents.get(1).getFirstname());
        verify(databaseRepo, times(1)).findAll();
    }

    @Test
    void testGetDetailsByLastname() {
        // Arrange
        String lastname = "Doe";
        when(databaseRepo.findByLastname(lastname)).thenReturn(Optional.of(student1));

        // Act
        StudentDetails foundStudent = studentService.getDetailsbylastname(lastname);

        // Assert
        assertNotNull(foundStudent);
        assertEquals("Doe", foundStudent.getLastname());
        verify(databaseRepo, times(1)).findByLastname("Doe");
    }

    @Test
    void testDeleteStudentById() {
        // Arrange
        List<StudentDetails> remainingAfterDelete = new ArrayList<>();
        remainingAfterDelete.add(student2);
        // Suppose we delete student with ID=1, we'll mock what the repo returns afterward
        when(databaseRepo.findAll()).thenReturn(remainingAfterDelete);

        // Act
        List<StudentDetails> updatedList = studentService.deleteStudentById(1L);

        // Assert
        assertEquals(1, updatedList.size());
        assertEquals("Jane", updatedList.get(0).getFirstname());
        verify(databaseRepo, times(1)).deleteById(1L);
        verify(databaseRepo, times(1)).findAll();
    }

    @Test
    void testUpdateStudentById() {
        // Arrange
        // Let's assume student1 is the "existing" record in the database
        when(databaseRepo.findById(1L)).thenReturn(Optional.of(student1));

        // We'll simulate updated data
        StudentDetails updatedInfo = new StudentDetails();
        updatedInfo.setFirstname("Johnny");
        updatedInfo.setLastname("Doe");
        updatedInfo.setEmail("johnny.doe@example.com");
        updatedInfo.setDob("1991-02-02");
        updatedInfo.setContact("1112223333");
        updatedInfo.setAddress("New Address");

        when(databaseRepo.save(any(StudentDetails.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        StudentDetails result = studentService.updateStudentById(1L, updatedInfo);

        // Assert
        assertNotNull(result);
        assertEquals("Johnny", result.getFirstname());
        assertEquals("Doe", result.getLastname());
        assertEquals("johnny.doe@example.com", result.getEmail());
        assertEquals("1991-02-02", result.getDob());
        assertEquals("1112223333", result.getContact());
        assertEquals("New Address", result.getAddress());

        verify(databaseRepo, times(1)).findById(1L);
        verify(databaseRepo, times(1)).save(any(StudentDetails.class));
    }

    @Test
    void testGetDetailsByLastname_NotFound() {
        // If the repository can't find the lastname, it returns Optional.empty()
        when(databaseRepo.findByLastname("Unknown")).thenReturn(Optional.empty());

        // If your code calls .get(), it will throw a NoSuchElementException
        // which you might handle globally. We'll just show that here:
        assertThrows(java.util.NoSuchElementException.class,
                () -> studentService.getDetailsbylastname("Unknown"));

        verify(databaseRepo, times(1)).findByLastname("Unknown");
    }
}
