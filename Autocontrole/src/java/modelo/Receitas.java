/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Sony Vaio
 */
public class Receitas {
    private int idReceitas;
    private String descricao;
    private float valor;
    private ReceitaDespesa rd;

    public ReceitaDespesa getRd() {
        return rd;
    }

    public void setRd(ReceitaDespesa rd) {
        this.rd = rd;
    }

    public int getIdReceitas() {
        return idReceitas;
    }

    public void setIdReceitas(int idReceitas) {
        this.idReceitas = idReceitas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
}
