package org.kodluyoruz.moviedb.service;

import org.kodluyoruz.moviedb.model.dbmodel.ProductionCompany;
import org.kodluyoruz.moviedb.repository.ProductionCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductionCompanyService extends MyEntityService<Integer, ProductionCompany, ProductionCompanyRepository> {

    @Autowired
    public ProductionCompanyService(ProductionCompanyRepository repository) {
        super(repository);
    }
}
