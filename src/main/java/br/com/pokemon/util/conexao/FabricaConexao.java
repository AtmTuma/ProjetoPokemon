package br.com.pokemon.util.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaConexao {

    private EntityManagerFactory factory;

    public void createFactory() {
        this.factory = Persistence.createEntityManagerFactory("ProjetoPokemon");
    }

    public EntityManager createEntityManager() {
        createFactory();
        return factory.createEntityManager();
    }

    public void closeEntityManager(EntityManager manager) {
        if (manager.isOpen()) {
            manager.close();
        }
    }
}
