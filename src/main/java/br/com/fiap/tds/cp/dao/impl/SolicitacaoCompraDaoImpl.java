package main.java.br.com.fiap.tds.cp.dao.impl;

import main.java.br.com.fiap.tds.cp.dao.SolicitacaoCompraDao;
import main.java.br.com.fiap.tds.cp.entity.SolicitacaoCompra;

import javax.persistence.EntityManager;

public class SolicitacaoCompraDaoImpl extends GenericDaoImpl<SolicitacaoCompra, Integer> implements SolicitacaoCompraDao {

    public SolicitacaoCompraDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
