package org.kodluyoruz.moviedb.service;

import lombok.Getter;
import org.kodluyoruz.moviedb.model.dbmodel.MyEntity;
import org.kodluyoruz.moviedb.repository.MyEntityRepository;

import java.io.Serializable;
import java.util.List;

public abstract class MyEntityService<
        ID extends Serializable,
        TEntity extends MyEntity<ID>,
        TRepository extends MyEntityRepository<ID, TEntity>>
{

    @Getter
    private final TRepository repository;

    protected MyEntityService(TRepository repository) {
        this.repository = repository;
    }

    public long count(){
        return getRepository().count();
    }

    public List<TEntity> findAll(){
        return getRepository().findAll();
    }

    public TEntity findById(ID id){
        return getRepository().getOne(id);
    }

    public boolean existsById(ID id){
        return getRepository().existsById(id);
    }

    public TEntity add(TEntity entity){
        return getRepository().saveAndFlush(entity);
    }

    public TEntity update(TEntity entity){
        if (entity.getId() == null || !existsById(entity.getId())) {
            throw new IllegalArgumentException("This entity does not exist: " + entity);
        }
        return add(entity);
    }

}
