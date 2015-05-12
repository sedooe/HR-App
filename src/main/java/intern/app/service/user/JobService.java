package intern.app.service.user;

import intern.app.domain.Job;
import intern.app.domain.JobCreateForm;

public interface JobService {
    Job create(JobCreateForm form);

    Job getJobById(long id);

    void deleteJobById(long id);
}
