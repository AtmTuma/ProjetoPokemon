package br.com.pokemon.bean;

import br.com.pokemon.dao.EspecieDao;
import br.com.pokemon.model.Especie;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

@ManagedBean(name = "especieBean")
@SessionScoped
public class EspecieBean extends Bean<Especie, EspecieDao>{

    private EntityManager manager;
    private EspecieDao dao;

    @Override
    public EspecieDao getDAO() {
        if(dao == null) {
            dao = new EspecieDao(manager);
        }
        return dao;
    }

    @Override
    public Especie criaNovaEntidade() {
        return new Especie();
    }

    public Especie carregar(Especie especie){

    }
}
