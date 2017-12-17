package br.com.pokemon.bean;

import br.com.pokemon.dao.EspecieDao;
import br.com.pokemon.dao.PokemonDao;
import br.com.pokemon.model.Pokemon;

import javax.persistence.EntityManager;

public class PokemonBean extends Bean<Pokemon, PokemonDao> {

    private EntityManager manager;
    private PokemonDao dao;

    @Override
    public PokemonDao getDAO() {
        if(dao == null) {
            dao = new PokemonDao(manager);
        }
        return dao;
    }

    @Override
    public Pokemon criaNovaEntidade() {
        return new Pokemon();
    }


}
