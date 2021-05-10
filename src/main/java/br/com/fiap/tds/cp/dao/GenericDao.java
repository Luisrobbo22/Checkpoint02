package main.java.br.com.fiap.tds.cp.dao;


import main.java.br.com.fiap.tds.cp.exception.CommitException;
import main.java.br.com.fiap.tds.cp.exception.EntityNotFoundException;

public interface GenericDao<E, K> {

    void create(E entity);

    E read(K id) throws EntityNotFoundException;

    void update(E entity);

    void delete(K id) throws EntityNotFoundException;

    void commit() throws CommitException;
}
