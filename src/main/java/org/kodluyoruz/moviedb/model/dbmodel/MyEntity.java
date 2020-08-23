package org.kodluyoruz.moviedb.model.dbmodel;

import java.io.Serializable;

public abstract class MyEntity<ID extends Serializable> implements Serializable
{
    public abstract ID getId();
    public abstract void setId(ID id);
}
