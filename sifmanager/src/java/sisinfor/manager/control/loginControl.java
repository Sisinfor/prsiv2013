/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sisinfor.manager.control;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import sisinfor.manager.bean.Usuario;
import sisinfor.manager.dao.UsuarioDAO;

/**
 *
 * @author raniere
 */
@ManagedBean
@RequestScoped
public class loginControl {
    private String login;
    private String senha;

    /**
     * Creates a new instance of loginControl
     */
    public loginControl() {
        this.login = "";
        this.senha = "";
        String erro = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("erro");
        if (erro != null)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR ,
                        "A sua sessão expirou!",""));
        }
        
    }
    
    public void logar()
    {
        UsuarioDAO usudao = new UsuarioDAO();
        Usuario usuario = usudao.getUsuario(this.getLogin());
        if (usuario.getLogin().length() > 0)
        {
            if (usuario.getSenha().compareTo(this.getSenha()) == 0)
            {
                HttpSession sessao = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                sessao.setAttribute("login", getLogin());
                sessao.setAttribute("usuario", usuario);

                //Redirecionar para a página principal
                try{
                    FacesContext.getCurrentInstance().getExternalContext().redirect("sistema/principal.jsf");
                }
                catch (Exception e)
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR ,
                        "Erro no Redirecionamento!",""));
                }
                
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR ,
                                    "Erro no Login:"," Senha inválida!"));
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR ,
                                "Erro no Login:"," Login não localizado!"));
        }
        
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
