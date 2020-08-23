package org.kodluyoruz.moviedb.model.dbmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "movies")
public class Movie extends MyEntity<Integer>{

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "budget")
    private Integer budget;

    @Column(name = "imdb_id", nullable = false,length = 50)
    private String imdbId;

    @Column(name = "org_lang",length = 5)
    private String originalLanguage;

    @Column(name = "org_title",length = 255)
    private String originalTitle;

    @Column(name = "overview",columnDefinition = "TEXT")
    @Lob
    private String overview;

    @Column(name = "poster",length = 255)
    private String poster;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "title",length = 255)
    private String title;

    @Column(name = "vote_count")
    private Integer voteCount;

    @Column(name = "vote_average")
    private Double voteAverage;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie", cascade = CascadeType.PERSIST)
    private List<ProductionCompany> productionCompanies=new LinkedList<>();

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie", cascade = CascadeType.PERSIST)
    private List<Cast> casts = new LinkedList<>();

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie", cascade = CascadeType.PERSIST)
    private List<Crew> crews = new LinkedList<>();

    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "movie_genres",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Genre> genres = new LinkedList<>();
}
