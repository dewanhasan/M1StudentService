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

public class StudentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "firstname cannot be blank")
    @Size(min = 2, max = 15, message = "Firstname must be between 2 and 15 characters")
    private String firstname;

    @NotBlank(message = "Name is mandatory")
    private String lastname;

    @NotBlank(message = "Email is mandatory")
    private String email;
}
