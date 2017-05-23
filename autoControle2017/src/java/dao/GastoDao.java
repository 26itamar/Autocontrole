/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.List;
import modelo.Gasto;


/**
 *
 * @author Sony Vaio
 */
public interface GastoDao {
    
    public void salvar(Gasto g);
    public void atualizar(Gasto g);
    public void remover(Gasto g);
    public List<Gasto> getListAll();
    public Gasto findById(int id);
    
    public List<Gasto> getListData(int id);
    
}
