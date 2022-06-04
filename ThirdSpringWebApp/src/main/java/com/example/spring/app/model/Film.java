package com.example.spring.app.model;

import javax.persistence.*;

// POJO
@Entity
@Table(name = "films")
public class Film {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private int year;

    @Column(name = "genre")
    private String genre;

    @Column(name = "watched")
    private boolean watched;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film)) return false;

        Film film = (Film) o;

        if (getId() != film.getId()) return false;
        if (getYear() != film.getYear()) return false;
        if (getTitle() != null ? !getTitle().equals(film.getTitle()) : film.getTitle() != null) return false;
        return getGenre() != null ? getGenre().equals(film.getGenre()) : film.getGenre() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + getYear();
        result = 31 * result + (getGenre() != null ? getGenre().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", watched=" + watched +
                '}';
    }
}
