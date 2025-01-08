package ie.atu.studentservicem1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "CourseCode cannot be blank")
    @Size(min = 2, max = 60, message = "CourseCode must be between 2 and 60 characters")
    private String courseCode;

    @NotBlank(message = "CourseDetails cannot be blank")
    @Size(min = 2, max = 60, message = "CourseDetails must be between 2 and 60 characters")
    private String courseDetails;

    private Long studentId;

}
