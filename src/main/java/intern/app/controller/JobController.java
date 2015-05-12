package intern.app.controller;

import intern.app.domain.ApplyForm;
import intern.app.domain.JobCreateForm;
import intern.app.service.application.AppService;
import intern.app.service.user.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Controller
public class JobController {
    private final JobService jobService;
    private final AppService appService;

    @Autowired
    public JobController(JobService jobService, AppService appService) {
        this.jobService = jobService;
        this.appService = appService;
    }

    @RequestMapping(value="/jobs/create", method = RequestMethod.GET)
    public ModelAndView getJobCreatePage() {
        return new ModelAndView("job_create", "form", new JobCreateForm());
    }

    @RequestMapping(value = "/jobs/create", method = RequestMethod.POST)
    public String handleJobCreateForm(@Valid @ModelAttribute("form") JobCreateForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "job_create";
        }
        jobService.create(form);
        return "redirect:/jobs";
    }

    @RequestMapping(value = "/jobs/{id}", method = RequestMethod.POST)
    public ModelAndView handleApplyForm(@PathVariable Long id, @Valid @ModelAttribute("form") ApplyForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return getJobPage(id);
        }
        appService.apply(form, id);
        return new ModelAndView("redirect:/jobs");
    }

    @RequestMapping(value = "/jobs/{id}", method = RequestMethod.GET)
    public ModelAndView getJobPage(@PathVariable Long id) {
        Map<String, Object> model = new HashMap<String, Object>();

        if (null == jobService.getJobById(id)) {
            throw new NoSuchElementException(String.format("Job=%s not found", id));
        } else {
            model.put("job", jobService.getJobById(id));
            model.put("form", new ApplyForm());
        }

        return new ModelAndView("job_detail", model);
    }

    @RequestMapping(params="delete", value = "/jobs/{id}", method = RequestMethod.POST)
    public String handleJobDeleteForm(@PathVariable Long id) {
        jobService.deleteJobById(id);
        return "redirect:/jobs";
    }
}