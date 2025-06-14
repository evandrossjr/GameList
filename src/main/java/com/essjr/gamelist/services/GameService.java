package com.essjr.gamelist.services;


import com.essjr.gamelist.dto.GameDTO;
import com.essjr.gamelist.dto.GameMinDTO;
import com.essjr.gamelist.entities.Game;
import com.essjr.gamelist.projections.GameMInProjection;
import com.essjr.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result =  gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x-> new GameMinDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        List<GameMInProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(x-> new GameMinDTO(x)).toList();

    }


    public void delete(Long id){
    gameRepository.deleteById(id);
    }


}
