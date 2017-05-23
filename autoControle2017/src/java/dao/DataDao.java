/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.List;
import modelo.Data;

/**
 *
 * @author Sony Vaio
 */
public interface DataDao {
    
    public void salvar(Data d);
    public void atualizar(Data d);
    public void remover(Data d);
    public List<Data> getListAll();
    public Data findById(int id);
  
}
