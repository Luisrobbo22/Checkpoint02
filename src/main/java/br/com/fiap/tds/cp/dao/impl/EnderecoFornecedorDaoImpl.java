package main.java.br.com.fiap.tds.cp.dao.impl;

import main.java.br.com.fiap.tds.cp.dao.EnderecoFornecedorDao;
import main.java.br.com.fiap.tds.cp.entity.EnderecoFornecedor;

import javax.persistence.EntityManager;

public class EnderecoFornecedorDaoImpl extends GenericDaoImpl<EnderecoFornecedor, Integer> implements EnderecoFornecedorDao {

    public EnderecoFornecedorDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
