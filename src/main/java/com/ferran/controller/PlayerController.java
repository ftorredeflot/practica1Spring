package com.ferran.controller;

import com.ferran.domain.Player;
import com.ferran.controller.util.HeaderUtil;
import com.ferran.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;
import java.net.URI;
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
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) throws URISyntaxException {
        Long id =player.getId();
        if (id != null) {
            return ResponseEntity.
                    badRequest().
                    headers(
                            HeaderUtil.
                                    createFailureAlert("player", "idexists", "A new player cannot already have an ID")).body(null);
        }
        Player result = playerRepository.save(player);
        return ResponseEntity.created(new URI("/players/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert("player", result.toString()))
                .body(result);

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
    public  ResponseEntity<Player>  findById(@PathVariable Long id){
        Player player =  playerRepository.findOne(id);
        if (player!=null){
            return new ResponseEntity<Player>(player,HttpStatus.OK);
        }else{
            log.debug("provant log : {}", player);
            return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);


        }

    }

    @RequestMapping(value = "/bypoints/{num}",
            method = RequestMethod.GET)
    public List<Player> findByPointsGreaterThan(@PathVariable Integer num){
        return playerRepository.findBynbasketsGreaterThanEqual(num);
    }

    @GetMapping("/orderby/baskets")
    public List<Player> findByOrderByNbaskets(){
        return playerRepository.findByOrderByNbaskets();
    }



}
