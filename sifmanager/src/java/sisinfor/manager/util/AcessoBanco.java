/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sisinfor.manager.util;
import java.sql.*;

/**
 *
 * @author raniere.sousa
 */
public class AcessoBanco {
    private String erro;
    private Statement stm;
    private ResultSet rs;
    private Connection conn;

    public AcessoBanco()
    {

    }
    public String Criar()
    {
                //Cria o ponto de acesso ao banco
        /*try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            try
            {
                this.url = "jdbc:mysql://"+this.servidor+"/"+this.banco;
                //javax.swing.JOptionPane.showMessageDialog( null, this.url);
                conn = DriverManager.getConnection(url,login,senha);
                try
                {
                    stm = conn.createStatement();
                    return "ok";
                }
                catch (Exception e)
                {
                    return "Erro na Criação do Statement" + e;
                }
            }
            catch (Exception e)
            {
                return "Erro na Conexão com o Banco"+e;
            }
        }
        catch (Exception e)
        {
            return "Erro no Carregamento do Driver"+e;
        }*/
        try {
                this.conn = Conexao.getConnection();
                this.stm = conn.createStatement();
                return "ok";


		} catch (Exception e) {
			// TODO Auto-generated catch block
                    System.out.println("Erro na abertura da Conexão:"+e.toString());
			return e.toString();
                }
                

    }
    public String Atualizar(String sql)
    {
        try
        {
            stm.executeUpdate(sql);
            return "ok";
        }
        catch (Exception e)
        {
            System.out.println("Erro na Gravação:"+e.toString());
            return "Erro no Cadastramento!"+e;
        }
    }
    public ResultSet GetCodigoGerado()
    {
        try
        {
            return stm.getGeneratedKeys();
        }
        catch (Exception e)
        {
            this.setErro(e.toString());
            return null;
        }
    }
    public ResultSet Executar(String sql)
    {
        try
        {
            rs = stm.executeQuery(sql);
            return rs;
        }
        catch (Exception e)
        {
            this.setErro(e.toString());
            System.out.println("Erro na execução de Script:"+e.toString());
            return null;
        }
    }
    public ResultSet ExecutaSP(String sql)
    {
       try
       {
           CallableStatement cs = conn.prepareCall(sql);
           ResultSet rs = cs.executeQuery();
           return rs;
       }
       catch (Exception e)
       {
           //JOptionPane.showMessageDialog(null, "Erro na Conexão da Stored Procedure:"+e);
           this.setErro(e.toString());
           System.out.println("Erro na execução de Procedure:"+e.toString());
           return null;
       }
    }

    public String ExecutaSPTexto(String sql)
    {
       try
       {
           CallableStatement cs = conn.prepareCall(sql);
           ResultSet rs = cs.executeQuery();
           return "ok";
       }
       catch (Exception e)
       {
           //JOptionPane.showMessageDialog(null, "Erro na Conexão da Stored Procedure:"+e);
           this.setErro(e.toString());
           System.out.println("Erro na execução de Procedure:"+e.toString());
           return e.toString();
       }
    }

    public int Fechar()
    {
        try
        {
            stm.close();
            conn.close();
            return 1;
        }
        catch (Exception e)
        {
            return -1;
        }
    }
    public Connection getConexao()
    {
        return conn;
    }

    /**
     * @return the erro
     */
    public String getErro() {
        return erro;
    }

    /**
     * @param erro the erro to set
     */
    public void setErro(String erro) {
        this.erro = erro;
    }

}
