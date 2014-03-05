package be.protracker.web.controllers;

import be.protracker.web.Coordinate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CoordinatesController {

    @RequestMapping(value = "/coords", method= RequestMethod.GET)
    @ResponseBody
    public void coords(@ModelAttribute("coordinate") Coordinate coordinate){
        System.out.print("test joeri");
        System.out.println(coordinate);
    }
}
