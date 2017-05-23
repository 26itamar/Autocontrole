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
public class Receita {
    private int id;
    private String descricaoReceita;
    private double valorReceita;
    private Data data;
    
    public Receita() {
        data = new Data();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricaoReceita(String descricaoReceita) {
        this.descricaoReceita = descricaoReceita;
    }

    public void setValorReceita(double valorReceita) {
        this.valorReceita = valorReceita;
    }

    public void setData(Data data) {
        this.data = data;
    }
     
    public int getId() {
        return id;
    }

    public String getDescricaoReceita() {
        return descricaoReceita;
    }

    public double getValorReceita() {
        return valorReceita;
    }

    public Data getData() {
        return data;
    }

   
}
