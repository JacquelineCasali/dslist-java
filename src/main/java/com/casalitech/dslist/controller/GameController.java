package com.casalitech.dslist.controller;

import com.casalitech.dslist.dto.GameMinDTO;

import com.casalitech.dslist.entities.Game;
import com.casalitech.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {
@Autowired
private GameService gameService;
@GetMapping
public List<GameMinDTO> findAll(){
    List<GameMinDTO>games=gameService.findAll();
    return games;
}

    @GetMapping("/{id}")
    public Game findById(@PathVariable Long id) throws Exception {
  Game game=gameService.findById(id);
        return game;


    }

}
