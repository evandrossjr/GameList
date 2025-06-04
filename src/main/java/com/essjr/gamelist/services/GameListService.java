package com.essjr.gamelist.services;

import com.essjr.gamelist.dto.GameListDTO;
import com.essjr.gamelist.entities.GameList;
import com.essjr.gamelist.repositories.GameListRepository;
import org.apache.catalina.LifecycleState;
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
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x->new GameListDTO(x)).toList();
    }
}
