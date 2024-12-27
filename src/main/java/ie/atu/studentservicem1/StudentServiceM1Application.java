package ie.atu.studentservicem1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class StudentServiceM1Application {

    public static void main(String[] args) {
        SpringApplication.run(StudentServiceM1Application.class, args);
    }

}
