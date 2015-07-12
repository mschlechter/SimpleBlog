package simpleblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import simpleblog.config.SimpleBlogConfig;

/**
 * Created by marc on 12/07/15.
 */
@Controller
public class LoginController {

    @Autowired
    private SimpleBlogConfig blogConfig;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error, ModelMap model) {

        ModelAndView mav = new ModelAndView();
        mav.addObject("blogConfig", blogConfig);

        if (error != null) {
            mav.addObject("error", "Sorry, incorrect credentials!");
        }

        mav.setViewName("login");

        return mav;
    }

    @RequestMapping(value="/loginError", method = RequestMethod.GET)
    public String loginError(ModelMap model) {
        model.addAttribute("error", "true");
        return "login";

    }

}
