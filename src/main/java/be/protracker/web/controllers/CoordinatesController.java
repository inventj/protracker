package be.protracker.web.controllers;

import be.protracker.repositories.mongo.CoordinateRepository;
import be.protracker.model.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@Controller
public class CoordinatesController {

    @Autowired
    private CoordinateRepository coordinateRepository;

    @RequestMapping(value = "/coords/add", method= RequestMethod.GET)
    @ResponseBody
    public void coords(@ModelAttribute("coordinate") Coordinate coordinate){
        coordinateRepository.save(new Coordinate(UUID.randomUUID().toString(),"120.1234567", "76.9879999"));
    }

    @RequestMapping(value = "/coords/list", method= RequestMethod.GET)
    @ResponseBody
    public List<Coordinate> coords(){
        System.out.print("list");

        return coordinateRepository.findAll();

    }
}
