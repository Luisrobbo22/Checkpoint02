package main.java.br.com.fiap.tds.cp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@SequenceGenerator(name = "funcionario", sequenceName = "SQ_LFL_FUNCIONARIO", allocationSize = 1)
@Table(name = "LFL_FUNCIONARIO")
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "funcionario", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_funcionario_solicitante")
    private Integer id;

    @Column(name = "nm_funcionario", length = 100, nullable = false)
    private String nome;

    @Column(name = "num_cpf", length = 20, nullable = false)
    private String cpf;

    @Column(name = "num_rg", length = 20, nullable = false)
    private String rg;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_nascimento", nullable = false)
    private Calendar dataNascimento;

    @OneToMany(mappedBy = "funcionario")
    private List<SolicitacaoCompra> solicitacaoCompras;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "LFL_ATIVIDADE",
            joinColumns = @JoinColumn(name = "id_funcionario_solicitante"),
            inverseJoinColumns = @JoinColumn(name = "id_atividade"))
    private List<Atividade> atividades;

    public void addSolicitacaoCompra(SolicitacaoCompra solicitacaoCompra) {
        if (solicitacaoCompras == null)
            solicitacaoCompras = new ArrayList<>();

        solicitacaoCompras.add(solicitacaoCompra);
        solicitacaoCompra.setFuncionario(this);
    }

    public Funcionario(){}

    public Funcionario(String nome, String cpf, String rg, Calendar dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
    }

    public Funcionario(String nome, String cpf, String rg, Calendar dataNascimento, List<Atividade> atividades) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.atividades = atividades;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<SolicitacaoCompra> getSolicitacaoCompras() {
        return solicitacaoCompras;
    }

    public void setSolicitacaoCompras(List<SolicitacaoCompra> solicitacaoCompras) {
        this.solicitacaoCompras = solicitacaoCompras;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }
}
