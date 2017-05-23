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
        
       // TODO Auto-generated method stub
        String sql = "delete from receitas where id = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, r.getId());

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Receita> getListAll() {
        
       List<Receita> listGasto = new ArrayList<>();
    
        String sql = "Select id, descricao_receita, valor_receita, id_data_r from receitas order by id";
        try {
            stmt = conn.prepareStatement(sql);
            rs  = stmt.executeQuery();
            
            while(rs.next()){
                Receita r = new Receita();
                r.setId(rs.getInt(1));
                r.setDescricaoReceita(rs.getString(2));
                r.setValorReceita(rs.getDouble(3));  
                       
                //cria um objeto data
                Data mes = new DataImpl().findById((rs.getInt(4)));
               
                r.setData(mes);
                 
                Data ano = new DataImpl().findById((rs.getInt(4)));
                
                r.setData(ano);
                
                listGasto.add(r);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GastoImpl.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return listGasto;
    
    }

    @Override
    public Receita findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public List<Receita> getListData(int id_data_r) {
     
    List<Receita> listReceitaData = new ArrayList<>();
    
        String sql = "Select id, descricao_receita, valor_receita, id_data_r "
                + "from receitas where id_data_r = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_data_r);
            rs = stmt.executeQuery();
               
            while(rs.next()){
                Receita r = new Receita();
                r.setId(rs.getInt(1));
                r.setDescricaoReceita(rs.getString(2));
                r.setValorReceita(rs.getDouble(3));
   
                //cria um objeto data
                Data mes = new DataImpl().findById((rs.getInt(4)));
               
                r.setData(mes);
                 
                Data ano = new DataImpl().findById((rs.getInt(4)));
                
                r.setData(ano);
                        
                listReceitaData.add(r);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GastoImpl.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return listReceitaData;
        
    }
    
    
}
