package com.ferran.service;
import com.ferran.domain.Player;
import com.ferran.domain.Team;
import com.ferran.repository.PlayerRepository;
import com.ferran.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
/**
 * Created by ferran on 20/10/16.
 */
@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    public void testPlayers(){

        Player p1 = new Player("fermin",LocalDate.of(1994,10,29), 10,3,2,"base");
        playerRepository.save(p1);

        System.out.println("Trobar per nom:");
        System.out.println(playerRepository.findByname(p1.getName()).toString());





    }
}
