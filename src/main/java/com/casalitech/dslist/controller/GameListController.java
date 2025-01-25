package com.casalitech.dslist.controller;

import com.casalitech.dslist.dto.GameListDTO;
import com.casalitech.dslist.dto.GameMinDTO;
import com.casalitech.dslist.services.GameListService;
import com.casalitech.dslist.services.GameService;
import com.casalitech.dslist.dto.ReplacementDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
@Autowired
private GameListService gameListService;
    @Autowired
    private GameService gameService;
@GetMapping
public List<GameListDTO> findAll(){
    List<GameListDTO>games=gameListService.findAll();
    return games;
}
    @GetMapping("/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable  Long listId){
        List<GameMinDTO>games=gameService.findByList(listId);
        return games;
    }

    @PostMapping("/{listId}/replacement")
    public void move(@PathVariable  Long listId, @RequestBody ReplacementDTO body){
gameListService.move(listId, body.getSourceIndex(),body.getDestinationIndex());
    }
}
