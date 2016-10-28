package com.ferran.controller;

import com.ferran.domain.Team;
import com.ferran.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Created by ferran on 28/10/16.
 */
@RestController
@RequestMapping("/team")
public class TeamController {
    private final Logger log = LoggerFactory.getLogger(PlayerController.class);

    @Autowired
    private TeamRepository teamRepository;
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Team createTeam(@RequestBody Team team){
        return teamRepository.save(team);

    }
    @RequestMapping(method =RequestMethod.GET)
    public List<Team> findAll(){
        return teamRepository.findAll();
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET)
    public Team findById(@PathVariable Long id){
        log.debug("REST request to delete Team: {}", id);
        Team team =  teamRepository.findOne(id);
        return team;
    }


}
