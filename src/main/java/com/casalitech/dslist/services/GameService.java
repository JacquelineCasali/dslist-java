package com.casalitech.dslist.services;

import com.casalitech.dslist.dto.GameMinDTO;
import com.casalitech.dslist.entities.Game;
import com.casalitech.dslist.repositores.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
@Autowired
private GameRepository gameRepository;
   public List<GameMinDTO> findAll(){
List<Game> games= gameRepository.findAll();
return games.stream().map(x -> new GameMinDTO(x)).toList();

   }

}
