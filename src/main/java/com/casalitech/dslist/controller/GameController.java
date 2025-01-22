package com.casalitech.dslist.controller;

import com.casalitech.dslist.dto.GameMinDTO;
import com.casalitech.dslist.entities.Game;
import com.casalitech.dslist.repositores.GameRepository;
import com.casalitech.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/games")
public class GameController {
@Autowired
private GameService gameService;
@Autowired
private GameRepository repository;
@GetMapping
public List<GameMinDTO> findAll(){
    List<GameMinDTO>games=gameService.findAll();
    return games;
}

    @GetMapping("/{id}")
    public Optional<Game> detalhar(@PathVariable Long id){
        return repository.findById(id);


    }

}
