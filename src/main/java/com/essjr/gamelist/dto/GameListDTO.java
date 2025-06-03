package com.essjr.gamelist.dto;

import com.essjr.gamelist.GamelistApplication;
import com.essjr.gamelist.entities.GameList;

public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO(){}

    public GameListDTO(GameList entity){
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
