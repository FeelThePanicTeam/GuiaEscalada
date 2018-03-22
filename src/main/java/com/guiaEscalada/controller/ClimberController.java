package com.guiaEscalada.controller;

import com.guiaEscalada.infrastructure.ClimberRepository;
import com.guiaEscalada.model.Climber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller("ClientController")
public class ClimberController {

    private final ClimberRepository climberRepository;

    @Autowired
    public ClimberController(ClimberRepository climberRepository) {
        this.climberRepository = climberRepository;
    }

    @RequestMapping(path = "/climbers", method = GET)
    public String listAllClimbers(Model model) {
        new Climber();
        model.addAttribute("name", "Juancho");
        return "climbers";
    }

    @RequestMapping(path = "/climbers", method = POST)
    @ResponseStatus(code = CREATED)
    public void createPatient(@RequestBody Climber climber) {
        climberRepository.saveAndFlush(climber);
    }
}