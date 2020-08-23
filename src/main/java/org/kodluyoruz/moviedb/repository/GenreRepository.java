package org.kodluyoruz.moviedb.repository;

import org.kodluyoruz.moviedb.model.dbmodel.Genre;

public interface GenreRepository extends MyEntityRepository<Integer, Genre> {

    Genre findByGenreId(Integer id);

}
