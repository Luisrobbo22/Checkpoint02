package main.java.br.com.fiap.tds.cp.dao.impl;

import main.java.br.com.fiap.tds.cp.dao.AtividadeDao;
import main.java.br.com.fiap.tds.cp.entity.Atividade;

import javax.persistence.EntityManager;

public class AtividadeDaoImpl extends GenericDaoImpl<Atividade, Integer> implements AtividadeDao {

    public AtividadeDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
