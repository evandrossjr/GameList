package com.essjr.gamelist.services;

import com.essjr.gamelist.dto.GameDTO;
import com.essjr.gamelist.dto.GameListDTO;
import com.essjr.gamelist.entities.GameList;
import com.essjr.gamelist.projections.GameMInProjection;
import com.essjr.gamelist.repositories.GameListRepository;
import com.essjr.gamelist.repositories.GameRepository;
import org.apache.catalina.LifecycleState;
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
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x->new GameListDTO(x)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){

        List<GameMInProjection> list = gameRepository.searchByList(listId);

        GameMInProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max;i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);


        }


    }
}
