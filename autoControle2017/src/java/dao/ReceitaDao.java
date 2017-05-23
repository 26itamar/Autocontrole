/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.List;
import modelo.Receita;

/**
 *
 * @author Sony Vaio
 */
public interface ReceitaDao {
    
    public void salvar(Receita r);
    public void atualizar(Receita r);
    public void remover(Receita r);
    public List<Receita> getListAll();
    public Receita findById(int id);
   
}
