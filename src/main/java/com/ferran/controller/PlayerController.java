package com.ferran.controller;

import com.ferran.domain.Player;
import com.ferran.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ferran on 24/10/16.
 */
@RestController
@RequestMapping("/players")
public class PlayerController {
    private final Logger log = LoggerFactory.getLogger(PlayerController.class);

    @Autowired
    private PlayerRepository playerRepository;
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Player createPlayer(@RequestBody Player player){
        return playerRepository.save(player);

    }
    @RequestMapping(method =RequestMethod.GET)
    public List<Player> findAll(){
        return playerRepository.findAll();
    }

    @RequestMapping(value = "/assists/{num}",
            method =RequestMethod.GET)
    public List<Player> findByAssists(@PathVariable Integer num){
        return playerRepository.findBynassistsGreaterThanEqual(num);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET)
    public Player findById(@PathVariable Long id){
        log.debug("REST request to delete Player : {}", id);
        Player player =  playerRepository.findOne(id);
        return player;
    }

    @RequestMapping(value = "/bypoints/{num}",
            method = RequestMethod.GET)
    public List<Player> findByPointsGreaterThan(@PathVariable Integer num){
        return playerRepository.findBynbasketsGreaterThanEqual(num);
    }



}
