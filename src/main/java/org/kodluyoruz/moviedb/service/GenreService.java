package org.kodluyoruz.moviedb.service;

import org.kodluyoruz.moviedb.model.dbmodel.Genre;
import org.kodluyoruz.moviedb.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService extends MyEntityService<Integer, Genre, GenreRepository> {

    @Autowired
    public GenreService(GenreRepository repository) {
        super(repository);
    }

    public Genre findByGenreId(Integer id) {
        return getRepository().findByGenreId(id);
    }

    public boolean existsByGenre(Integer id) {
        return findByGenreId(id) != null;
    }

}
