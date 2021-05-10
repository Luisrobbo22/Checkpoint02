package main.java.br.com.fiap.tds.cp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@SequenceGenerator(name = "atividade", sequenceName = "SQ_LFL_ATIVIDADE", allocationSize = 1)
@Table(name = "LFL_ATIVIDADE")
public class Atividade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "atividade", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_atividade")
    private Integer id;

    @Column(name = "ds_atividade", length = 100, nullable = false)
    private String descricao;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_inicio")
    private Calendar dataInicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_termino")
    private Calendar dataTermino;

    @ManyToMany(mappedBy = "atividades")
    private List<Funcionario> funcionarios;

    public void addFuncionarios(Funcionario funcionario) {
        if (funcionarios == null)
            funcionarios = new ArrayList<>();
        funcionarios.add(funcionario);
        List<Atividade> atvs = new ArrayList<>();
        atvs.add(this);
        funcionario.setAtividades(atvs);
    }


    public Atividade() {
    }

    public Atividade(String descricao, Calendar dataInicio, Calendar dataTermino) {
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
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

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Calendar getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Calendar dataTermino) {
        this.dataTermino = dataTermino;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
