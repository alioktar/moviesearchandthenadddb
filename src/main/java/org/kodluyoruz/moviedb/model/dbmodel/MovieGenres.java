package org.kodluyoruz.moviedb.model.dbmodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "movie_genres")
@NamedQuery(name = "Genre.findByGenre", query = "select mg from MovieGenres mg where mg.genre = ?1")
@NamedQuery(name = "Genre.findByMovie", query = "select mg from MovieGenres mg where mg.movie = ?1")
public class MovieGenres extends MyEntity<Integer> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id",referencedColumnName = "id", nullable = false)
    private Movie movie;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id",referencedColumnName = "id", nullable = false)
    private Genre genre;
}
