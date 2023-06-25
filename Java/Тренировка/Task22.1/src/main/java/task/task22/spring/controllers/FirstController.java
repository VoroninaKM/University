package task.task22.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import task.task22.spring.model.Model;

@Controller
public class FirstController {

    Model model = new Model();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView Page1() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/random.html");
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView Page2(@ModelAttribute("mod") Model mod) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/result");
        model.setPar1(mod.getPar1());
        model.setPar2(mod.getPar2());
        return modelAndView;
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public ModelAndView Page3() {
        ModelAndView modelAndView = new ModelAndView();
        int[] list = model.main(model.getPar1(),model.getPar2());
        modelAndView.addObject("list", list);
        modelAndView.addObject("average", model.average());
        modelAndView.addObject("par1", model.getPar1());
        modelAndView.addObject("par2", model.getPar2());
        modelAndView.addObject("v1", list[0]);
        modelAndView.addObject("v2", list[1]);
        modelAndView.addObject("v3", list[2]);
        modelAndView.addObject("v4", list[3]);
        modelAndView.addObject("v5", list[4]);
        modelAndView.addObject("v6", list[5]);
        modelAndView.addObject("v7", list[6]);
        modelAndView.addObject("v8", list[7]);
        modelAndView.addObject("v9", list[8]);
        modelAndView.addObject("v10", list[9]);
        modelAndView.setViewName("/result.html");
        return modelAndView;
    }
}
