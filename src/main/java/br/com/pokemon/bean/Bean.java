package br.com.pokemon.bean;

import br.com.pokemon.dao.Dao;
import br.com.pokemon.util.exception.ErroSistema;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Bean<E, D extends Dao<E>> {
    private E entidade;
    private List<E> entidades;

    public abstract D getDAO();
    public abstract E criaNovaEntidade();

    public void novo() {
        this.entidade = criaNovaEntidade();
    }

    public void listar() {
        try {
            setEntidades(getDAO().findAll());
            if(getEntidades() == null && getEntidades().isEmpty()) {
                adicionarMensagem("Não tem nada cadastrado!", FacesMessage.SEVERITY_WARN);
            }
        } catch (ErroSistema ex) {
            Logger.getLogger(Bean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void buscarNome(String nome) {
        try {
            setEntidades(getDAO().findByName(nome));
            if(getEntidades().isEmpty()) {
                adicionarMensagem("Não tem nada cadastrado!", FacesMessage.SEVERITY_WARN);
            }
        } catch (ErroSistema ex) {
            Logger.getLogger(Bean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void cadastrar() {
        try {
            getDAO().save(entidade);
            adicionarMensagem("Salvo com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            Logger.getLogger(Bean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void editar(E entidade) {
        try {
            getDAO().save(entidade);
            adicionarMensagem("Salvo com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            Logger.getLogger(Bean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void excluir(E entidade){
        try {
            getDAO().delete(entidade);
            entidades.remove(entidade);
            adicionarMensagem("Deletado com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            Logger.getLogger(Bean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void adicionarMensagem(String mensagem, FacesMessage.Severity tipoErro) {
        FacesMessage ms = new FacesMessage(tipoErro, mensagem, null);
        FacesContext.getCurrentInstance().addMessage(null, ms);
    }

    public E getEntidade() {
        return entidade;
    }
    public void setEntidade(E entidade) {
        this.entidade = entidade;
    }
    public List<E> getEntidades() {
        return entidades;
    }
    public void setEntidades(List<E> entidades) {
        this.entidades = entidades;
    }
}
