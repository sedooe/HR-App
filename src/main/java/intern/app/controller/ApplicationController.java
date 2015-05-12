package intern.app.controller;

import intern.app.service.application.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.NoSuchElementException;

@Controller
public class ApplicationController {
    private final AppService appService;

    @Autowired
    public ApplicationController(AppService appService) {
        this.appService = appService;
    }

    @RequestMapping(value = "/applications/{id}", method = RequestMethod.GET)
    public ModelAndView getApplicationPage(@PathVariable Long id) {
        if (null == appService.getAppById(id)) {
            throw new NoSuchElementException(String.format("Application=%s not found", id));
        } else {
            return new ModelAndView("application_detail", "app", appService.getAppById(id));
        }
    }
}
