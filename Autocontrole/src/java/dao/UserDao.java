package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sony Vaio
 */
public class UserDao {
    public boolean validaSenha(String senha, String confirmSenha){
return (senha.equals(confirmSenha))? true : false;
}
}
