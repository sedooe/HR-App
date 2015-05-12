package intern.app.controller;

import intern.app.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JobsController {
    private final JobRepository repository;

    @Autowired
    public JobsController(JobRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/jobs")
    public ModelAndView getJobsPage() {
        return new ModelAndView("jobs", "jobs", repository.findAll());
    }


}
