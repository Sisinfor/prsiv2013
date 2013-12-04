/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sisinfor.manager.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import sisinfor.manager.bean.Usuario;
import sisinfor.manager.util.AcessoBanco;

/**
 *
 * @author raniere
 */
public class UsuarioDAO implements Serializable{

    public Usuario getUsuario(String wlogin)
    {
        try{
            AcessoBanco acesso = new AcessoBanco();
            String status = acesso.Criar();
            if (status.compareTo("ok") == 0)
            {
                ResultSet rs = acesso.Executar("SELECT U_USUARIO,U_NOME,U_LOGIN,U_SENHA,U_EMAIL "
                        + "FROM USUARIO WHERE U_LOGIN = '"+wlogin.trim()+"'");

                Usuario usuario = new Usuario();

                if (rs.next())
                {
                    usuario.setUsuario(rs.getInt(1));
                    usuario.setNome(rs.getString(2));
                    usuario.setLogin(rs.getString(3));
                    usuario.setSenha(rs.getString(4));
                    usuario.setEmail(rs.getString(5));
                }
                acesso.Fechar();
                return usuario;
            }
            else
            {
                System.out.println("Erro getUsuario:"+status);
                return null;
            }
        }
        catch (Exception e)
        {
            System.out.println("Erro getUsuario:"+e.toString());
            return null;
        }
    }
        
}
