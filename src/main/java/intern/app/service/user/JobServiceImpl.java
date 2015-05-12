package intern.app.service.user;

import intern.app.domain.*;
import intern.app.repository.JobRepository;
import intern.app.service.user.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class JobServiceImpl implements JobService {
    private final JobRepository repository;

    @Autowired
    public JobServiceImpl(JobRepository repository) {
        this.repository = repository;
    }

    public Job create(JobCreateForm form) {
        Job job = new Job(form.getTitle(), form.getNumPeopleToHire());
        job.setDescription(form.getDescription());
        try {
            job.setLastDate(form.getLastDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return repository.save(job);
    }

    public Job getJobById(long id) {
        return repository.findOne(id);
    }

    public void deleteJobById(long id) {
        repository.delete(id);
    }
}
