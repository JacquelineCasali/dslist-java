package com.casalitech.dslist.services;

import com.casalitech.dslist.dto.GameListDTO;
import com.casalitech.dslist.dto.GameMinDTO;
import com.casalitech.dslist.entities.Game;
import com.casalitech.dslist.entities.GameList;
import com.casalitech.dslist.projections.GameMinProjection;
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

@Autowired
private GameRepository gameRepository;

    @Transactional(readOnly = true)
   public List<GameListDTO> findAll(){
List<GameList> games= gameListRepository.findAll();
return games.stream().map(x -> new GameListDTO(x)).toList();

   }

// reposizicionar um game
   //id da lista , posição de origem , posição de destino
@Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
// buscar os games da lista
    List<GameMinProjection> list= gameRepository.searchByList(listId);
    // movimentar item
    //remove elemento
    GameMinProjection obj= list.remove(sourceIndex);
    //inserir objeto
    list.add(destinationIndex,obj);
    // min e maximo
int min =sourceIndex < destinationIndex?sourceIndex:destinationIndex;
    int max =sourceIndex < destinationIndex?destinationIndex:sourceIndex;
for(int i=min;i<=max;i++){
    //lista,game, posicao
    gameListRepository.updateBelongingPosition(listId,list.get(i).getId(),i);
}
}




}
