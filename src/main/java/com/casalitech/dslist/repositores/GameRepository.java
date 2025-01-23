package com.casalitech.dslist.repositores;
import com.casalitech.dslist.dto.GameDTO;
import com.casalitech.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface GameRepository extends JpaRepository<Game, Long> {

  }
