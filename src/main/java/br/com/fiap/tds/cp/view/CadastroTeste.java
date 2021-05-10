package main.java.br.com.fiap.tds.cp.view;

import main.java.br.com.fiap.tds.cp.dao.*;
import main.java.br.com.fiap.tds.cp.dao.impl.*;
import main.java.br.com.fiap.tds.cp.entity.*;
import main.java.br.com.fiap.tds.cp.exception.CommitException;
import main.java.br.com.fiap.tds.cp.singleton.EntityManagerFactorySingleton;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.*;

public class CadastroTeste {
    public static final Logger log = LoggerFactory.logger(CadastroTeste.class);

    public static void main(String[] args) {
        log.info("[CadastroTeste] - Instanciando um Entity Manager");
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

        log.info("[CadastroTeste] - Instanciando todos os DAO's.");

        EnderecoFornecedorDao enderecoFornecedorDao = new EnderecoFornecedorDaoImpl(em);
        FornecedorDao fornecedorDao = new FornecedorDaoImpl(em);
        SolicitacaoCompraDao solicitacaoCompraDao = new SolicitacaoCompraDaoImpl(em);
        FuncionarioDao funcionarioDao = new FuncionarioDaoImpl(em);
        AtividadeDao atividadeDao = new AtividadeDaoImpl(em);

        log.info("[CadastroTeste] - Instanciando todas as Entidades.");


        EnderecoFornecedor enderecoFornecedor =
                new EnderecoFornecedor("Rua do Fornecedor, No 258", "São Caetano do Sul",
                        "São Paulo", "Brasil", "09430-000");

        Fornecedor fornecedor =
                new Fornecedor("Descrição do fornecedor 01 teste", "36.438.508/0001-13", enderecoFornecedor);

        SolicitacaoCompra solicitacaoCompra =
                new SolicitacaoCompra("Descrição da solicitação de compra 01 teste", Calendar.getInstance(),
                        10, new BigDecimal(1500));

        Funcionario funcionario = new Funcionario("José", "003.257.540-80", "19.010.214-7", new GregorianCalendar(2003, Calendar.JANUARY, 03));
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(funcionario);

        Atividade atividade1 =
                new Atividade("Descrição da tividade 01", Calendar.getInstance(), new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DATE + 1)));

        Atividade atividade2 =
                new Atividade("Descrição da tividade 02", Calendar.getInstance(), new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DATE + 1)));

        atividade1.addFuncionarios(funcionario);
        atividade2.addFuncionarios(funcionario);

        List<Atividade> atividades = new ArrayList<>();
        atividades.addAll(Arrays.asList(atividade1, atividade2));

        log.info("[CadastroTeste] - Relacionando as Entidades");

        fornecedor.addSolicitacaoCompra(solicitacaoCompra);
        funcionario.addSolicitacaoCompra(solicitacaoCompra);
        funcionario.setAtividades(atividades);


        log.info("[CadastroTeste] - Cadastrando todos pela entidade SolicitacaoCompra");

        try {
            solicitacaoCompraDao.create(solicitacaoCompra);
            solicitacaoCompraDao.commit();

            log.info("Fornecedor e EnderecoFornecedor cadastrados");
        } catch (CommitException e) {
            log.error(e.getMessage());
        }


        em.close();
        EntityManagerFactorySingleton.getInstance().close();
        log.info("[CadastroTeste] - Conexão fechada");


    }
}
