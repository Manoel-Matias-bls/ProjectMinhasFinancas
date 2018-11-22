package info.cmn.projectminhasfinancas;

import java.io.Serializable;
import java.util.Date;

public class Receita implements Serializable {

    private String Operacao;
    private int id;
    private String tipoOp;
    private String valor;
    private String data;
    private String descricao;
    private String categoria;


    public Receita(int id, String valor, String data, String descricao) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
    }

    public String getOperacao() {
        return Operacao;
    }

    public void setOperacao(String operacao) {
        Operacao = operacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoOp() {
        return tipoOp;
    }

    public void setTipoOp(String tipoOp) {
        this.tipoOp = tipoOp;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Id: "+ getId()+ "\nData: "+getData()+ "\nValor: "+getValor()+ "\nDescrição: "+getDescricao();
    }
}
