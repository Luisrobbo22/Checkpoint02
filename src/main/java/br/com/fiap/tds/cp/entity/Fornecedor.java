package main.java.br.com.fiap.tds.cp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@SequenceGenerator(name = "fornecedor", sequenceName = "SQ_LFL_FORNECEDOR", allocationSize = 1)
@Table(name = "LFL_FORNECEDOR")
public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "fornecedor", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_fornecedor")
    private Integer id;

    @Column(name = "ds_fornecedor", length = 100, nullable = false)
    private String descricao;

    @Column(name = "num_cnpj", length = 20, nullable = false)
    private String cnpj;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_fornecedor_endereco")
    private EnderecoFornecedor enderecoFornecedor;

    @OneToMany(mappedBy = "fornecedor")
    private List<SolicitacaoCompra> solicitacaoCompras;

    public void addSolicitacaoCompra(SolicitacaoCompra solicitacaoCompra) {
        if (solicitacaoCompras == null)
            solicitacaoCompras = new ArrayList<>();

        solicitacaoCompras.add(solicitacaoCompra);
        solicitacaoCompra.setFornecedor(this);
    }

    public Fornecedor() {
    }

    public Fornecedor(String descricao, String cnpj) {
        this.descricao = descricao;
        this.cnpj = cnpj;
    }

    public Fornecedor(String descricao, String cnpj, EnderecoFornecedor enderecoFornecedor) {
        this.descricao = descricao;
        this.cnpj = cnpj;
        this.enderecoFornecedor = enderecoFornecedor;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public EnderecoFornecedor getEnderecoFornecedor() {
        return enderecoFornecedor;
    }

    public void setEnderecoFornecedor(EnderecoFornecedor enderecoFornecedor) {
        this.enderecoFornecedor = enderecoFornecedor;
    }

    public List<SolicitacaoCompra> getSolicitacaoCompras() {
        return solicitacaoCompras;
    }

    public void setSolicitacaoCompras(List<SolicitacaoCompra> solicitacaoCompras) {
        this.solicitacaoCompras = solicitacaoCompras;
    }
}
