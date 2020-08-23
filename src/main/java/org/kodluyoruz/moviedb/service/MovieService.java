package org.kodluyoruz.moviedb.service;

import org.kodluyoruz.moviedb.model.dbmodel.Movie;
import org.kodluyoruz.moviedb.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService extends MyEntityService<Integer, Movie, MovieRepository> {

    @Autowired
    public MovieService(MovieRepository repository) {
        super(repository);
    }
}
