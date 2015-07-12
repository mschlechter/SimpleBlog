package simpleblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import simpleblog.config.SimpleBlogConfig;

/**
 * Created by marc on 12/07/15.
 */
@Controller
public class AboutController {

    @Autowired
    private SimpleBlogConfig blogConfig;

    @RequestMapping(value="/about", method = RequestMethod.GET)
    public ModelAndView about()
    {
        ModelAndView mav = new ModelAndView("about");
        mav.addObject("blogConfig", blogConfig);

        return mav;
    }



}
