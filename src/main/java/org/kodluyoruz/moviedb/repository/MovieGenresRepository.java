package org.kodluyoruz.moviedb.repository;

import org.kodluyoruz.moviedb.model.dbmodel.Genre;
import org.kodluyoruz.moviedb.model.dbmodel.Movie;
import org.kodluyoruz.moviedb.model.dbmodel.MovieGenres;

import java.util.List;

public interface MovieGenresRepository extends MyEntityRepository<Integer, MovieGenres> {

    List<MovieGenres> findByGenre(Genre genre);

    List<MovieGenres> findByMovie(Movie movie);

}
