package intern.app;

import intern.app.domain.Job;
import intern.app.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    JobRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    public void run(String... strings) throws Exception {
        Job job1 = new Job("Software Engineer", 1);
        job1.setDescription("Some description about job");
        job1.setLastDate("13/05/2015");

        Job job2 = new Job("UI Designer", 5);
        job2.setDescription("Some description about job");
        job2.setLastDate("13/05/2015");

        Job job3 = new Job("System Engineer", 3);
        job3.setDescription("Some description about job");
        job3.setLastDate("13/05/2015");

        repository.save(job1);
        repository.save(job2);
        repository.save(job3);
    }
}