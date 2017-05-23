/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;


import dao.ConnectionFactory;
import dao.ReceitaDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Data;
import modelo.Receita;

/**
 *
 * @author Sony Vaio
 */
public class ReceitaImpl implements ReceitaDao{
    
    Connection conn = ConnectionFactory.getConnection();
    PreparedStatement stmt;
    ResultSet rs;

    @Override
    public void salvar(Receita r) {
        
        try {
            String sql = "insert into receitas "
                    + "(descricao_receita, valor_receita, id_data_r) values(?,?,?)";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, r.getDescricaoReceita());
            stmt.setDouble(2, r.getValorReceita());
            stmt.setInt(3, r.getData().getId());
            

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
 
    }

    @Override
    public void atualizar(Receita r) {
        
        // TODO Auto-generated method stub
        String sql = "update receita set descricao_receita = ?, valor_receita = ?, "
                + "id_data_r =? where id = ?";
        
        try {
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, r.getDescricaoReceita());
            stmt.setDouble(2, r.getValorReceita());
            stmt.setInt(3, r.getData().getId());
            // atualia onde o contato for igual a esse id
            stmt.setInt(4, r.getId());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }

    @Override
    public void remover(Receita r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Receita> getListAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Receita findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
