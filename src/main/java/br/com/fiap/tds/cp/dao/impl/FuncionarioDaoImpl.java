package main.java.br.com.fiap.tds.cp.dao.impl;

import main.java.br.com.fiap.tds.cp.dao.FuncionarioDao;
import main.java.br.com.fiap.tds.cp.entity.Funcionario;

import javax.persistence.EntityManager;

public class FuncionarioDaoImpl extends GenericDaoImpl<Funcionario, Integer> implements FuncionarioDao {

    public FuncionarioDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
