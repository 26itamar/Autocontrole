/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.GastoDao;
import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Data;
import modelo.Gasto;

/**
 *
 * @author Sony Vaio
 */
public class GastoImpl implements GastoDao {
    
    Connection conn = ConnectionFactory.getConnection();
    PreparedStatement stmt;
    ResultSet rs;

    @Override
    public void salvar(Gasto g) {
       String sql = "INSERT INTO Gastos (descricao_gato, valor_gasto, id_data_g) VALUES(?,?,?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, g.getDescricaoGasto());
            stmt.setDouble(2, g.getValorgasto());
            stmt.setDouble(3, g.getData().getId());
            
            stmt.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(Gasto.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
    }
   }

    @Override
    public void atualizar(Gasto g) {
     
    }

    @Override
    public void remover(Gasto g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Gasto> getListAll() {
     
    List<Gasto> listGasto = new ArrayList<>();
    
        String sql = "Select id, descricao_gasto, valor_gasto, id_data_g from gastos order by id";
        try {
            stmt = conn.prepareStatement(sql);
            rs  = stmt.executeQuery();
            
            while(rs.next()){
                Gasto g = new Gasto();
                g.setId(rs.getInt(1));
                g.setDescricaoGasto(rs.getString(2));
                g.setValorgasto(rs.getDouble(3));  
                //g.getData().setId(rs.getInt(4));     
                
                //cria um objeto cidade
                Data mes = new DataImpl().findById((rs.getInt(4)));
               
                g.setData(mes);
                 
                Data ano = new DataImpl().findById((rs.getInt(4)));
                
                g.setData(ano);
                
                listGasto.add(g);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GastoImpl.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return listGasto;
    
    }

    @Override
    public Gasto findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
