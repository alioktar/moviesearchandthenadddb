package org.kodluyoruz.moviedb.service;

import org.kodluyoruz.moviedb.model.dbmodel.Cast;
import org.kodluyoruz.moviedb.repository.CastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
public class CastService extends MyEntityService<Integer, Cast, CastRepository> {

    @Autowired
    public CastService(CastRepository repository) {
        super(repository);
    }

    EntityManager entityManager;
    @Transactional
    public void insertWithQuery(Cast cast) {
        entityManager.createNativeQuery("insert into casts (name, `character`, image, `order`, movie_id) values (?, ?, ?, ?, ?)")
                .setParameter(1, cast.getId())
                .executeUpdate();
    }

}
