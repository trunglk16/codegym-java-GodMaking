package sky.god.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import sky.god.model.Thing;
import sky.god.service.ThingService;

@Controller
public class ThingController {
    @Autowired
    private ThingService thingService;

    @GetMapping("/thing/s")
    public ModelAndView listCustomers(Pageable pageable) {
        Page<Thing> things = thingService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/things/index");
        modelAndView.addObject("things", things);
        return modelAndView;
    }

    @GetMapping("/thing")
    public ModelAndView showCreatePage(){
        ModelAndView modelAndView = new ModelAndView("/things/create");
        modelAndView.addObject("thing", new Thing());
        return modelAndView;
    }

    @PostMapping("/thing")
    public ModelAndView saveNews(@Validated @ModelAttribute("thing") Thing thing,  BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/things/create");
            modelAndView.addObject("message", "Name and Description empty");
            return modelAndView;
        } else {
            thingService.save(thing);
            ModelAndView modelAndView = new ModelAndView("/things/create");
            modelAndView.addObject("thing", new Thing());
            modelAndView.addObject("message", "Thing created successfully");
            return modelAndView;
        }
    }

    @GetMapping("/thing/{id}")
    public ModelAndView viewNews(@PathVariable Long id) {
        Thing thing = thingService.findById(id);
        if (thing != null) {
            ModelAndView modelAndView = new ModelAndView("/things/view");
            modelAndView.addObject("thing", thing);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }



}
