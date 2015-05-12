package intern.app.controller;

import intern.app.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicationsController {
    private final ApplicationRepository repository;

    @Autowired
    public ApplicationsController(ApplicationRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/applications")
    public ModelAndView getJobsPage() {
        return new ModelAndView("applications", "applications", repository.findAll());
    }


}
