package org.kodluyoruz.moviedb.repository;

import org.kodluyoruz.moviedb.model.dbmodel.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface MyEntityRepository<ID extends Serializable, TEntity extends MyEntity<ID>>
        extends JpaRepository<TEntity, ID> {

}
