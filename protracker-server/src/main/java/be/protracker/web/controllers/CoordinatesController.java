package main.java.be.protracker.web.controllers;

import main.java.be.protracker.repositories.mongo.CoordinateRepository;
import main.java.be.protracker.model.Coordinate;
import main.java.be.protracker.repositories.mongo.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CoordinatesController {

    @Autowired
    private CoordinateRepository coordinateRepository;

    @Autowired
    private DriverRepository driverRepo;


    @RequestMapping(value = "/coords/add", method = RequestMethod.GET)
    @ResponseBody
    public void coords(@ModelAttribute("coordinate") Coordinate coordinate) {

        Integer i = 0;
        coordinateRepository.save(new Coordinate((i++).toString(), "51.19605", "5.5080418"));
        coordinateRepository.save(new Coordinate((i++).toString(), "51.196682", "5.5071835"));
        coordinateRepository.save(new Coordinate((i++).toString(), "51.1968303", "5.506905"));
        coordinateRepository.save(new Coordinate((i++).toString(), "51.1971194", "5.5063686"));
        coordinateRepository.save(new Coordinate((i++).toString(), "51.1972538", "5.5062076"));
        coordinateRepository.save(new Coordinate((i++).toString(), "51.197395", "5.5059609"));
        coordinateRepository.save(new Coordinate((i++).toString(), "51.1974892", "5.5057677"));
        coordinateRepository.save(new Coordinate((i++).toString(), "51.1978186", "5.5053601"));
        coordinateRepository.save(new Coordinate((i++).toString(), "51.1981816", "5.5047163"));
        coordinateRepository.save(new Coordinate((i++).toString(), "51.1982892", "5.5045768"));
        coordinateRepository.save(new Coordinate((i++).toString(), "51.1963832", "5.5054459"));

    }

    @RequestMapping(value = "/coords/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Coordinate> coords() {
        System.out.print("list");

        return coordinateRepository.findAll();

    }
}
