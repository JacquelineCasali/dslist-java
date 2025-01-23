package com.casalitech.dslist.services;

import com.casalitech.dslist.dto.GameListDTO;
import com.casalitech.dslist.dto.GameMinDTO;
import com.casalitech.dslist.entities.Game;
import com.casalitech.dslist.entities.GameList;
import com.casalitech.dslist.repositores.GameListRepository;
import com.casalitech.dslist.repositores.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
@Autowired
private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
   public List<GameListDTO> findAll(){
List<GameList> games= gameListRepository.findAll();
return games.stream().map(x -> new GameListDTO(x)).toList();

   }






}
