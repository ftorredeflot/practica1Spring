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
        Player p2 = new Player("pepe",LocalDate.of(1984,12,19), 150,120,20,"pibot");
        Player p3 = new Player("javier metalero",LocalDate.of(1988,1,29), 140,30,25,"alero");
        Player p4 = new Player("kelvin",LocalDate.of(1990,8,29), 106,63,42,"base");
        Player p5 = new Player("danyl",LocalDate.of(1995,7,29), 180,36,72,"pibot");
        Player p6 = new Player("jorgito",LocalDate.of(1989,12,29), 190,93,92,"alero");
        Player p7 = new Player("mariano",LocalDate.of(1991,1,29), 10,43,2,"base");
        Player p8 = new Player("paco",LocalDate.of(1996,10,9), 150,23,2,"pibot");
        Player p9 = new Player("bojan",LocalDate.of(1999,10,29), 109,93,2,"alero");
        Player p10 = new Player("gerard",LocalDate.of(2000,1,29), 160,3,2,"base");
        Player p11 = new Player("dani",LocalDate.of(1985,2,25), 10,40,2,"pibot");
        Player p12 = new Player("pedro",LocalDate.of(1994,3,29), 180,3,2,"alero");
        Player p13 = new Player("cristian",LocalDate.of(1992,4,29), 170,3,2,"base");
        Player p14 = new Player("alfredo",LocalDate.of(1996,5,29), 190,3,2,"pibot");
        Player p15 = new Player("ricard",LocalDate.of(1997,6,29), 190,3,2,"alero");


        Team t1=new Team("barça","barcelona",LocalDate.of(1899,1,1));
        Team t2=new Team("madrid","madrid",LocalDate.of(1903,1,1));
        Team t3=new Team("Bilbao","bilbao",LocalDate.of(1905,1,1));
        teamRepository.save(t1);
        teamRepository.save(t2);
        teamRepository.save(t3);

        p1.setTeam(t1);
        p2.setTeam(t1);
        p3.setTeam(t1);
        p4.setTeam(t1);
        p5.setTeam(t1);
        p6.setTeam(t2);
        p7.setTeam(t2);
        p8.setTeam(t2);
        p9.setTeam(t2);
        p10.setTeam(t2);
        p11.setTeam(t3);
        p12.setTeam(t3);
        p13.setTeam(t3);
        p14.setTeam(t3);
        p15.setTeam(t3);


        playerRepository.save(p1);
        playerRepository.save(p2);
        playerRepository.save(p3);
        playerRepository.save(p4);
        playerRepository.save(p5);
        playerRepository.save(p6);
        playerRepository.save(p7);
        playerRepository.save(p8);
        playerRepository.save(p9);
        playerRepository.save(p10);
        playerRepository.save(p11);
        playerRepository.save(p12);
        playerRepository.save(p13);
        playerRepository.save(p14);
        playerRepository.save(p15);











        System.out.println("Trobar per nom: que conte");
        System.out.println(playerRepository.findBynameContaining("fer"));
        System.out.println("Trobar per nom:");
        System.out.println(playerRepository.findByname(p2.getName()));

        System.out.println("numero de canastas");
        System.out.println(playerRepository.findBynbasketsGreaterThanEqual(120));

        System.out.println("numero de canastas por rango");
        System.out.println(playerRepository.findBynbasketsBetween(107,120));

        System.out.println("tots els bases:");
        System.out.println(playerRepository.findByposEquals("base"));

        System.out.println("edad anterior a 29-10-1989");
        System.out.println(playerRepository.findBybirthdateAfter(LocalDate.of(1994,10,29)));




    }
}
