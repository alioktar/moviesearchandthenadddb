package org.kodluyoruz.moviedb.service;

import org.kodluyoruz.moviedb.model.dbmodel.Crew;
import org.kodluyoruz.moviedb.repository.CrewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrewService extends MyEntityService<Integer, Crew, CrewRepository> {

    @Autowired
    public CrewService(CrewRepository repository) {
        super(repository);
    }
}
