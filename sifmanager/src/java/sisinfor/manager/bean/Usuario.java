/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sisinfor.manager.bean;

import java.io.Serializable;

/**
 *
 * @author raniere
 */
public class Usuario implements Serializable{
    private int usuario;
    private String nome;
    private String login;
    private String senha;
    private String email;

    public Usuario()
    {
        this.usuario = 0;
        this.nome = "";
        this.login = "";
        this.senha = "";
        this.email = "";
    }
    /**
     * @return the usuario
     */
    public int getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
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

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
