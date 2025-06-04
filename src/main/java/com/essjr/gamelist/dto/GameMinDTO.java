package com.essjr.gamelist.dto;

import com.essjr.gamelist.entities.Game;
import com.essjr.gamelist.projections.GameMInProjection;
import jakarta.persistence.Column;

public class GameMinDTO {

    private Long id;
    private String title;
    private Integer gameYear;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO(){}


    public GameMinDTO(Game entity) {
        id = entity.getId();
        this.title = entity.getTitle();
        this.gameYear = entity.getGameYear();
        this.imgUrl = entity.getImgUrl();
        this.shortDescription = entity.getShortDescription();
    }

    public GameMinDTO(GameMInProjection projection) {
        id = projection.getId();
        this.title = projection.getTitle();
        this.gameYear = projection.getGameYear();
        this.imgUrl = projection.getImgUrl();
        this.shortDescription = projection.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getGameYear() {
        return gameYear;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

}


