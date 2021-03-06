package br.com.pokemon.bean;

import br.com.pokemon.dao.AtaqueDao;
import br.com.pokemon.dao.EspecieDao;
import br.com.pokemon.model.Ataque;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

@ManagedBean(name = "ataqueBean")
@SessionScoped
public class AtaqueBean extends Bean<Ataque, AtaqueDao> {

    private EntityManager manager;
    private AtaqueDao dao;

    @Override
    public AtaqueDao getDAO() {
        if(dao == null) {
            dao = new AtaqueDao(manager);
        }
        return dao;
    }

    @Override
    public Ataque criaNovaEntidade() {
        return new Ataque();
    }

}
