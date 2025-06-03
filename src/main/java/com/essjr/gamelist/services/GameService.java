package com.essjr.gamelist.services;


import com.essjr.gamelist.dto.GameMinDTO;
import com.essjr.gamelist.entities.Game;
import com.essjr.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        List<Game> result =  gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x-> new GameMinDTO(x)).toList();
        return dto;



    }
}
