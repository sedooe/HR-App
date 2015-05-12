package intern.app.service.application;

import intern.app.domain.ApplyForm;
import intern.app.domain.JobApplication;

public interface AppService {
    JobApplication apply(ApplyForm form, long jobId);

    JobApplication getAppById(long id);
}
