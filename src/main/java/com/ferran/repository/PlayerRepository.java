package com.ferran.repository;

import com.ferran.domain.Player;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * Created by ferran on 17/10/16.
 */
public interface PlayerRepository extends JpaRepository<Player, Long> {

    //Spring Data Queries

    List<Player> findByname(String name);
    List<Player> findBynameContaining(String name);
    List<Player> findBynbasketsGreaterThanEqual(Integer nbaskets);
    List<Player> findBynbasketsBetween(Integer mbaskets, Integer maxbaskets);
    List<Player> findByposEquals(String posicio);
    List<Player> findBybirthdateAfter(LocalDate edat);
    List<Player> findByTeamName(String name);
    List<Player> findByTeamNameAndPos(String name,String pos);


}
