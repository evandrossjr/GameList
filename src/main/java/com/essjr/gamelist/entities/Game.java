package com.essjr.gamelist.entities;

import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class Game {

    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String plataform;
    private String imgUrl;

    public Game() {    }

    public Game(Long id, String title, Integer year, String genre, String plataform, String imgUrl) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.plataform = plataform;
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlataform() {
        return plataform;
    }

    public void setPlataform(String plataform) {
        this.plataform = plataform;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) && Objects.equals(title, game.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", plataform='" + plataform + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
