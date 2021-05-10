package main.java.br.com.fiap.tds.cp.dao.impl;

import main.java.br.com.fiap.tds.cp.dao.FornecedorDao;
import main.java.br.com.fiap.tds.cp.entity.Fornecedor;

import javax.persistence.EntityManager;

public class FornecedorDaoImpl extends GenericDaoImpl<Fornecedor, Integer> implements FornecedorDao {

    public FornecedorDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
