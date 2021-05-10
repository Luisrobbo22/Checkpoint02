package main.java.br.com.fiap.tds.cp.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@SequenceGenerator(name = "endereco_fornecedor",  sequenceName = "SQ_LFL_FORNECEDOR_ENDERECO", allocationSize = 1)
@Table(name = "LFL_FORNECEDOR_ENDERECO")
public class EnderecoFornecedor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "endereco_fornecedor", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_fornecedor_endereco")
    private Integer id;

    @Column(name = "nm_rua", length = 200, nullable = false)
    private String rua;

    @Column(name = "nm_cidade", length = 200, nullable = false)
    private String cidade;

    @Column(name = "nm_estado", length = 50, nullable = false)
    private String estado;

    @Column(name = "nm_pais",length = 100, nullable = false)
    private String pais;

    @Column(name = "codigo_postal", length = 10, nullable = false)
    private String codigoPostal;

    @OneToOne(mappedBy = "enderecoFornecedor", cascade = CascadeType.ALL)
    private Fornecedor fornecedor;

    public EnderecoFornecedor() {
    }

    public EnderecoFornecedor(String rua, String cidade, String estado, String pais, String codigoPostal) {
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
    }

    public EnderecoFornecedor(String rua, String cidade, String estado, String pais, String codigoPostal, Fornecedor fornecedor) {
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
        this.fornecedor = fornecedor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
