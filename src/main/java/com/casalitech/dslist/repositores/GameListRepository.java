package com.casalitech.dslist.repositores;

import com.casalitech.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GameListRepository extends JpaRepository<GameList, Long> {

  }
