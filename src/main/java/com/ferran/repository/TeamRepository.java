package com.ferran.repository;

import java.util.List;

import com.ferran.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by ferran on 20/10/16.
 */
public interface TeamRepository  extends JpaRepository<Team, Long> {

}
