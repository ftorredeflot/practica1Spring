package com.ferran.repository;

import com.ferran.domain.Player;
import com.ferran.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.StringQueryParameterBinder;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by ferran on 17/10/16.
 */
public interface PlayerRepository extends JpaRepository<Player, Long> {

    //Spring Data Queries

    List<Player> findByname(String name);
    List<Player> findBynameContaining(String name);
    List<Player> findBynbasketsGreaterThanEqual(Integer nbaskets);
    List<Player> findBynassistsGreaterThanEqual(Integer nassists);
    List<Player> findBynbasketsBetween(Integer mbaskets, Integer maxbaskets);
    List<Player> findByposEquals(String posicio);
    List<Player> findBybirthdateAfter(LocalDate edat);
    List<Player> findByTeamName(String name);
    List<Player> findByTeamNameAndPos(String name,String pos);

    @Query("SELECT player.pos , AVG(player.nbaskets),  AVG(player.nassists), AVG(player.nrebots) from Player player GROUP BY player.pos")
    List <Object[]> findAVGStatisticsFromPosition();

    @Query("SELECT player.pos , AVG(player.nbaskets),  AVG(player.nassists), AVG(player.nrebots), " +
            "MIN(player.nbaskets),  MIN(player.nassists), MIN(player.nrebots), " +
            "MAX(player.nbaskets),  MAX(player.nassists), MAX(player.nrebots) from Player player GROUP BY player.pos")
    List <Object[]> findAVGMINMAXStatisticsFromPosition();

    @Query("SELECT player from Player player WHERE player.team = :team AND player.nbaskets IN (SELECT MAX(player.nbaskets) FROM Player player WHERE player.team = :team)")
    List<Player> findMaxPointsPlayerByTeam(@Param("team") Team team);




}
