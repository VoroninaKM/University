package task.task16.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import task.task16.spring.model.Model;

import java.util.Objects;

@Controller
public class FirstController {

    Model model = new Model();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView Page1() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/calculator.html");
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView Page2(@ModelAttribute("mod") Model mod) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/result");
        model.setPar1(mod.getPar1());
        model.setPar2(mod.getPar2());
        model.setAction(mod.getAction());
        if (Objects.equals(model.getAction(), "summation")) {
            model.summation();
        } else if (Objects.equals(model.getAction(), "subtraction")){
            model.subtraction();
        } else if (Objects.equals(model.getAction(), "division")) {
            model.division();
        } else if (Objects.equals(model.getAction(), "multiplication")) {
            model.multiplication();
        } else if (Objects.equals(model.getAction(), "exponentiation")){
            model.exponentiation();
        }
        return modelAndView;
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public ModelAndView Page3() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("par1", model.getPar1());
        modelAndView.addObject("par2", model.getPar2());
        modelAndView.addObject("result", model.getResult());
        modelAndView.setViewName("/result.html");
        return modelAndView;
    }
}
