package main.java.br.com.fiap.tds.cp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

@Entity
@SequenceGenerator(name = "solicitacao_compra", sequenceName = "SQ_LFL_SOLICITACAO_COMPRA", allocationSize = 1)
@Table(name = "LFL_SOLICITACAO_COMPRA")
public class SolicitacaoCompra implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "solicitacao_compra", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_solicitacao")
    private Integer id;

    @Column(name = "ds_solicitacao", length = 100, nullable = false)
    private String descricao;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_solicitacao", nullable = false)
    private Calendar dataSolicitacao;

    @Column(name = "vl_quantidade", nullable = false )
    private Integer quantidade;

    @Column(name = "vl_solicitacao", nullable = false)
    private BigDecimal valor;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "solicitacaoCompras")
    private Fornecedor fornecedor;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;


    public SolicitacaoCompra() {
    }

    public SolicitacaoCompra(String descricao, Calendar dataSolicitacao, Integer quantidade, BigDecimal valor) {
        this.descricao = descricao;
        this.dataSolicitacao = dataSolicitacao;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Calendar getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Calendar dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
