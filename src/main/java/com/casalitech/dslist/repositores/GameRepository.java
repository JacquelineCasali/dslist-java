package com.casalitech.dslist.repositores;
import com.casalitech.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GameRepository extends JpaRepository<Game, Long> {
}
