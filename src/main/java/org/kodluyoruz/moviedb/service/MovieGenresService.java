package org.kodluyoruz.moviedb.service;

import org.kodluyoruz.moviedb.model.dbmodel.Genre;
import org.kodluyoruz.moviedb.model.dbmodel.Movie;
import org.kodluyoruz.moviedb.model.dbmodel.MovieGenres;
import org.kodluyoruz.moviedb.repository.MovieGenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieGenresService extends MyEntityService<Integer, MovieGenres, MovieGenresRepository> {

    @Autowired
    public MovieGenresService(MovieGenresRepository repository) {
        super(repository);
    }

    public List<MovieGenres> findByGenre(Genre genre){
        return getRepository().findByGenre(genre);
    }

    public List<MovieGenres> findByMovie(Movie movie){
        return getRepository().findByMovie(movie);
    }

}
