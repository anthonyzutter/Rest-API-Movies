package com.anthony.MovieDB.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "titles")
public class Title {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    @NotEmpty(message = "Name cannot be empty or null")
    private String name;
    @NotEmpty(message = "Description cannot be empty or null")
    private String description;
//    @NotEmpty(message = "Description cannot be empty or null")
    private Date releaseDate;
    private Boolean isMovie;

    @JsonIgnoreProperties("title")
    @OneToMany(mappedBy= "title", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Poster> posters = new HashSet<Poster>();

    @JsonIgnoreProperties("titles")
    @ManyToMany(mappedBy = "titles", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Set<Genre> genres = new HashSet<Genre>();

    @JsonIgnoreProperties("title")
    @OneToMany(mappedBy= "title", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Season> seasons = new HashSet<Season>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Set<Poster> getPosters() {
        return posters;
    }

    public void setPosters(Set<Poster> posters) {
        this.posters = posters;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Boolean getMovie() {
        return isMovie;
    }

    public void setMovie(Boolean movie) {
        isMovie = movie;
    }

    public Set<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(Set<Season> seasons) {
        this.seasons = seasons;
    }

    public void addGenre(Genre genre) {
        this.getGenres().add(genre);
        genre.getTitles().add(this);
    }

    public void deleteGenre(Genre genre) {
        this.getGenres().remove(genre);
        genre.getTitles().remove(this);
    }

    @Override
    public String toString() {
        return "Title{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", releaseDate=" + releaseDate +
                ", isMovie=" + isMovie +
                ", posters=" + posters +
                ", genres=" + genres +
                ", seasons=" + seasons +
                '}';
    }
}
