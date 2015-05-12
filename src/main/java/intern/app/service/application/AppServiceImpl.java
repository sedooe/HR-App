package intern.app.service.application;

import intern.app.domain.ApplyForm;
import intern.app.domain.JobApplication;
import intern.app.repository.ApplicationRepository;
import intern.app.repository.JobRepository;
import intern.app.service.application.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppServiceImpl implements AppService {
    private final ApplicationRepository appRepository;
    private final JobRepository jobRepository;

    @Autowired
    public AppServiceImpl(ApplicationRepository appRepository, JobRepository jobRepository) {
        this.appRepository = appRepository;
        this.jobRepository = jobRepository;
    }

    public JobApplication apply(ApplyForm form, long jobId) {
        JobApplication app = new JobApplication(form.getFirstName(), form.getLastName());
        app.setEmail(form.getEmail());
        app.setPhone(form.getPhone());
        app.setAddress(form.getAddress());
        app.setThoughts(form.getThoughts());
        app.setJob(jobRepository.findOne(jobId));
        return appRepository.save(app);
    }

    public JobApplication getAppById(long id) {
        return appRepository.findOne(id);
    }


}
