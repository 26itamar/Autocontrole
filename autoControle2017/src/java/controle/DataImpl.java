/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DataDao;
import dao.ConnectionFactory;
import static dao.Dao.conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Data;

/**
 *
 * @author Sony Vaio
 */
public class DataImpl implements DataDao  {
    
    Connection conn = ConnectionFactory.getConnection();
    PreparedStatement stmt;
    ResultSet rs;

    @Override
    public void salvar(Data d) {
        String sql = "INSERT INTO data (mes, ano) VALUES(?,?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, d.getMes());
            stmt.setString(2, d.getAno());
            
            stmt.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DataImpl.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    @Override
    public void atualizar(Data d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Data d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Data>  getListAll() {
        
         List<Data> listData = new ArrayList<>();
        
        String sql = "select * from data";
        try {
            stmt = conn.prepareStatement(sql);
            rs  = stmt.executeQuery();
            
            while(rs.next()){
                Data d = new Data();
                d.setId(rs.getInt(1));
                d.setMes(rs.getString(2));
                d.setAno(rs.getString(3));
                listData.add(d);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DataImpl.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return listData;
    }

    @Override
    public Data findById(int id) {
        
        String sql = "select id, mes, ano "
                + "from data where id = ?";
        Data data = new Data();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.next();
            data.setId(rs.getInt(1));
            data.setMes(rs.getString(2));
            data.setAno(rs.getString(3));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    
    }
  
}
